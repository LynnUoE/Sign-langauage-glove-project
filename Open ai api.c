#include <stdio.h>
#include <curl/curl.h>
#include <json-c/json.h>

void generate_text(const char* prompt) {
    CURL *curl;
    CURLcode res;
    struct curl_slist *headers = NULL;
    struct json_object *json, *response_data;

    curl_global_init(CURL_GLOBAL_ALL);
    curl = curl_easy_init();

    if(curl) {
        const char* api_key = "YOUR_OPENAI_API_KEY"; // Replace with your API key
        char post_data[1024];

        // Set up the JSON object
        json = json_object_new_object();
        json_object_object_add(json, "prompt", json_object_new_string(prompt));
        json_object_object_add(json, "max_tokens", json_object_new_int(50));
        sprintf(post_data, "model=davinci&%s", json_object_to_json_string(json));

        // Set up the headers
        headers = curl_slist_append(headers, "Content-Type: application/json");
        char auth_header[100];
        sprintf(auth_header, "Authorization: Bearer %s", api_key);
        headers = curl_slist_append(headers, auth_header);

        curl_easy_setopt(curl, CURLOPT_URL, "https://api.openai.com/v1/engines/davinci/completions");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, post_data);

        // Perform the request, res will get the return code
        res = curl_easy_perform(curl);

        // Check for errors
        if(res != CURLE_OK) {
            fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
        }

        // Always cleanup
        curl_easy_cleanup(curl);

        // Clean up JSON object
        json_object_put(json);
    }

    curl_global_cleanup();
}

int main() {
    char prompt[1024];

    printf("Enter your prompt: ");
    fgets(prompt, sizeof(prompt), stdin); // Reads a line from stdin

    // Remove newline character, if present
    size_t len = strlen(prompt);
    if (len > 0 && prompt[len - 1] == '\n') {
        prompt[len - 1] = '\0';
    }

    generate_text(prompt);
    return 0;
}
