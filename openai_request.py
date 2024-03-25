import requests
from openai import OpenAI

def translate_text(text, source_lang, target_lang):
    api_key = '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'
    headers = {
        'Content-Type': 'application/json',
        'Authorization': f'Bearer {api_key}'
    }
    prompt = f"Translate from {source_lang} to {target_lang}: {text}"
    data = {
        'model': 'gpt-3.5-turbo',
        'messages': [{'role': 'user', 'content': prompt}],
        'max_tokens': 200
    }
    response = requests.post('https://api.openai.com/v1/chat/completions', json=data, headers=headers)
    if response.status_code == 200:
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
    if translated_text:
        print("Translated Text:")
        print(translated_text)

if __name__ == "__main__":
    main()
