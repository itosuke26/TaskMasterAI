from transformers import pipeline, set_seed

# シードを設定してランダム性をコントロール
set_seed(42)

# 日本語対応の生成AIモデルの設定
generator = pipeline('text-generation', model='cyberagent/open-calm-medium', do_sample=True)

def generate_task_goal(prompt):
    result = generator(prompt, max_length=200, max_new_tokens=100, num_return_sequences=1, truncation=True, repetition_penalty=3.0, top_p=0.9, temperature=0.7)
    return result[0]['generated_text']

if __name__ == "__main__":
    prompt = """
タスク: ITパスポートの取得
具体的なステップ、目標、期限を含めてください。
1. 第1週: ITパスポート試験の範囲を確認し、主要な科目をリストアップする。
2. 第2週: 各科目の基本的な学習資料を集め、毎日の学習スケジュールを作成する。
3. 第3週: 基本的な用語や概念を学習し、クイズ形式で理解度をチェックする。
4. 第4週: 模擬試験を受けて弱点を把握し、重点的に復習する。
5. 第5週～第8週: 週に1回模擬試験を受け、進捗を確認しつつ学習を続ける。
6. 第9週～第12週: 総復習を行い、過去問題集を解く。最終準備として直前対策を実施する。
7. ITパスポート試験を受験し、合格を目指す。
"""
    print(generate_task_goal(prompt).encode('utf-8', 'ignore').decode('utf-8'))