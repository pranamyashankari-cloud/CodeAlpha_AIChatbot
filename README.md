# CodeAlpha AI Chatbot

A console-based Java FAQ chatbot using lightweight, rule-based NLP. It normalizes user text and selects answers using keyword and phrase matching; it does not use a trained machine-learning model or an external AI API.

## Features
- Interactive chat loop with exit commands.
- Text normalization (lowercase and punctuation cleanup).
- FAQ responses for Java, JVM, OOP, arrays, loops, and the internship project.
- Help and fallback responses for unknown questions.

## Requirements
- Java 17 or newer

## Run
```bash
javac src/AIChatbot.java
java -cp src AIChatbot
```

## Concepts used
String processing, methods, conditionals, loops, and rule-based natural language processing.
