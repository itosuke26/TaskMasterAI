from transformers import pipeline, set_seed

# シードを設定してランダム性をコントロール
set_seed(42)

# 日本語対応の生成AIモデルの設定
try:
    generator = pipeline('text-generation', model='sonoisa/t5-base-japanese', do_sample=True)
except Exception as e:
    print(f"sonoisa/t5-base-japanese model failed with error: {e}")
    print("Switching to cl-tohoku/bert-base-japanese model.")
    generator = pipeline('text-generation', model='cl-tohoku/bert-base-japanese', do_sample=True)

def generate_task_goal(prompt):
    result = generator(prompt, max_length=100, num_return_sequences=1, truncation=True, repetition_penalty=2.0, top_p=0.95, temperature=0.8)
    return result[0]['generated_text']

if __name__ == "__main__":
    prompt = "次のタスクの目標を設定してください。タスク: 新しいプロジェクトの準備。具体的なステップ、目標、期限を含めてください。例：リサーチの完了、プレゼンテーションの作成、チームへの連絡など。"
    print(generate_task_goal(prompt).encode('utf-8', 'ignore').decode('utf-8'))