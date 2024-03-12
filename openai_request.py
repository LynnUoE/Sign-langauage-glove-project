import requests
from openai import OpenAI

def generate_text(prompt):
    api_key = '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'
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {api_key}'
    }
    data = {
        'prompt': prompt,
        'max_tokens': 200
    }
    response = requests.post('https://api.openai.com/v1/engines/davinci/completions', json=data, headers=headers)
    if response.status_code == 200:
        text = response.json().get('choices', [{}])[0].get('text', '').strip()
        return text
    else:
        print(f"Error: {response.status_code}")
        return None

def main():
    user_prompt = input("Enter your prompt: ")
    generated_text = generate_text(user_prompt)
    if generated_text:
        print("Generated Text:")
        print(generated_text)

if __name__ == "__main__":
    main()
