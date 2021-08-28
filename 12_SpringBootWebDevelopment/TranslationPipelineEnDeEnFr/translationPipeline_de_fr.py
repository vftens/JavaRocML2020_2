#
#import gradio as gr
from transformers import pipeline


translation_pipeline = pipeline('translation_en_to_de')
translation_pipeline2 = pipeline('translation_en_to_fr')
print("Listening en to de and fr")

while(True):
    inp=input()
    answer=translation_pipeline(inp)
    answer2=translation_pipeline2(inp)
    print(answer[0]['translation_text'])
    print(answer2[0]['translation_text'])

def translate_transformers(from_text):
    result = translation_pipeline(from_text)
    return(result[0]['translation_text'])

