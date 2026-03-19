# 🧮 Calculadora de 8 Dígitos

Calculadora simples em Java com suporte a operações básicas e limite de 8 dígitos no resultado.

## ✨ Funcionalidades

- ➕ Soma
- ➖ Subtração
- ✖️ Multiplicação
- ➗ Divisão
- ⚠️ Validação de limite de 8 dígitos
- 🚫 Proteção contra divisão por zero
- 💻 Interface de linha de comando interativa

## 🚀 Como executar

### Pré-requisitos
- Java 11+
- Maven 3.6+

### Compilar e rodar
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.calculadora.Main"
```

### Gerar JAR executável
```bash
mvn package
java -jar target/calculadora-sample.jar
```

### Rodar os testes
```bash
mvn test
```

## 📁 Estrutura do projeto

```
calculadora-sample/
├── src/
│   ├── main/java/com/calculadora/
│   │   ├── Calculadora.java   # Lógica da calculadora
│   │   └── Main.java          # Interface CLI
│   └── test/java/com/calculadora/
│       └── CalculadoraTest.java  # Testes unitários (JUnit 5)
├── pom.xml
└── README.md
```

## 🧪 Testes

O projeto inclui testes unitários com JUnit 5 cobrindo:
- Operações básicas (soma, subtração, multiplicação, divisão)
- Casos com zero e negativos
- Limite de 8 dígitos
- Exceções (divisão por zero, overflow)

## 📏 Regras da calculadora

| Condição | Comportamento |
|----------|--------------|
| Resultado > 99.999.999 | Lança `ArithmeticException` |
| Resultado < -9.999.999 | Lança `ArithmeticException` |
| Divisão por zero | Lança `ArithmeticException` |
