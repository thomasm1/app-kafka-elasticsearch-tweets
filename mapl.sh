#!/bin/bash
echo "Calling MyPersonalLibrarian via OpenAI..."
MY_OPENAI_KEY="${OPENAI_API_KEY}"
PROMPT="Tell me about the World"

curl https://api.openai.com/v1/chat/completions \
-H "Content-Type: application/json" \
-H "Authorization: Bearer ${MY_OPENAI_KEY}" \
-d '{ "model": "gpt-4", "messages": [{"role":"user", "content": "'"${PROMPT}"'"}] }'
