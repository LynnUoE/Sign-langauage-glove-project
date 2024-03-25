import requests
import tkinter as tk
from tkinter import ttk

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

def translate():
    text = text_entry.get("1.0", tk.END).strip()
    source_lang = source_lang_entry.get()
    target_lang = target_lang_entry.get()
    translated_text = translate_text(text, source_lang, target_lang)
    result_text.delete("1.0", tk.END)
    result_text.insert(tk.END, translated_text)

# Create the main window
window = tk.Tk()
window.title("Translation Tool")

# Create and pack the widgets
source_lang_label = ttk.Label(window, text="Source Language:")
source_lang_label.pack()
source_lang_entry = ttk.Entry(window)
source_lang_entry.pack()

target_lang_label = ttk.Label(window, text="Target Language:")
target_lang_label.pack()
target_lang_entry = ttk.Entry(window)
target_lang_entry.pack()

text_label = ttk.Label(window, text="Text to Translate:")
text_label.pack()
text_entry = tk.Text(window, height=5)
text_entry.pack()

translate_button = ttk.Button(window, text="Translate", command=translate)
translate_button.pack()

result_label = ttk.Label(window, text="Translated Text:")
result_label.pack()
result_text = tk.Text(window, height=5)
result_text.pack()

# Start the Tkinter event loop
window.mainloop()