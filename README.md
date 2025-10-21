# 🧮 Calculadora CI/CD
![Java CI](https://github.com/TU-USUARIO/calculadora-ci-devops/workflows/Java%
20CI%20con%20Maven/badge.svg)
![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.9-blue)
![License](https://img.shields.io/badge/License-MIT-green)
## 📝 Descripción
Proyecto de ejemplo para aprender DevOps y CI/CD con Java, Maven y GitHub Act
ions.
## 🚀 Características
- Integración Continua con GitHub Actions
- Tests automatizados con JUnit 5
- Build automatizado con Maven
- Generación de artefactos JAR
## 🏗️ Estructura del Proyecto
calculadora-ci/
├── src/ │
├── main/java/co/edu/javeriana/demo/ │
│ └── Calculadora.java
└── test/java/co/edu/javeriana/demo/ │
└── CalculadoraTest.java
├── .github/workflows/ │
└── ci.yml
├── pom.xml
└── README.md
## Ejecutar Localmente
### Prerequisitos
- Java JDK 17+
- Maven 3.9+
### Comandos
```bash
# Compilar
mvn clean compile
# Ejecutar tests
mvn test
# Generar JAR
mvn package
📊Funcionalidades de la Calculadora
• Sumar dos números
• Restar dos números
• Multiplicar dos números
• Dividir dos números
• Calcular módulo
🔄CI/CD Pipeline
Cada push ejecuta automáticamente:
1. Compilación con Maven
2. Ejecución de tests
3. Generación de reportes
4. Empaquetado del JAR
5. Upload del artefacto
👥Autores
Luna Rengifo
Camilo Moreno
Nicolas Castañeda
Nicolas Leon
Samuel Nemes