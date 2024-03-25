import requests
from openai import OpenAI

def translate_text(text, source_lang, target_lang):
    # Set up the OpenAI API key
    api_key = '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'
    
    # Set up the headers for the API request
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {api_key}'
    }
    
    # Create the prompt for translation
    prompt = f"Translate from {source_lang} to {target_lang}: {text}"
    
    # Set up the data for the API request
    data = {
        'model': 'gpt-3.5-turbo',
        'messages': [{'role': 'user', 'content': prompt}],
        'max_tokens': 200
    }
    
    # Make the API request to OpenAI's chat completion endpoint
    response = requests.post('https://api.openai.com/v1/chat/completions', json=data, headers=headers)
    
    # Check if the API request was successful (status code 200)
    if response.status_code == 200:
        # Extract the translated text from the API response
        translated_text = response.json().get('choices', [{}])[0].get('message', {}).get('content', '').strip()
        return translated_text
    else:
        print(f"Error: {response.status_code}")
        print(f"Error message: {response.text}")
        return None

def main():
    source_lang = input("Enter the source language: ")
    target_lang = input("Enter the target language: ")
    text = input("Enter the text to translate: ")
    translated_text = translate_text(text, source_lang, target_lang)
    
    # Check if the translation was successful
    if translated_text:
        print("Translated Text:")
        print(translated_text)

if __name__ == "__main__":
    main()
