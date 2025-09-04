# 🐯 Tigrinho Apostador - App Android Educacional

> **Aplicativo Android educativo com tom sarcástico sobre jogos de apostas, desenvolvido para projeto acadêmico.**

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![API](https://img.shields.io/badge/API-24%2B-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-Educational-blue?style=for-the-badge)

</div>

---

## 📱 Sobre o Projeto

O **Tigrinho Apostador** é um aplicativo Android desenvolvido como projeto acadêmico que simula um jogo de apostas de forma **educativa e sarcástica**. O objetivo é **alertar sobre os riscos dos jogos de azar** através de mensagens humorísticas e mecânicas que demonstram como esses jogos funcionam na realidade.

### ⚠️ **IMPORTANTE**
Este aplicativo tem **caráter puramente educacional** e **não incentiva apostas reais**. Todas as mensagens sarcásticas têm o propósito de **desencorajar** o vício em jogos de azar.

---

## 🎯 Objetivos do Projeto

- ✅ **Acadêmico**: Demonstrar uso de múltiplos componentes Android
- ✅ **Educacional**: Conscientizar sobre riscos de jogos de aposta
- ✅ **Técnico**: Aplicar boas práticas de desenvolvimento Kotlin/Android
- ✅ **Interface**: Criar Single Screen App funcional e responsiva

---

## 📦 Componentes Utilizados (11+ Widgets)

O projeto utiliza **mais de 11 componentes diferentes** conforme requisitado:

### 🔹 **Componentes de Interface**
1. **📱 ImageView** - Exibe ícone vetorial do tigrinho com animações
2. **📝 TextView** - Múltiplos usos (títulos, saldo, resultados, mensagens)
3. **⌨️ EditText** - Campo de entrada para valor da aposta
4. **🔘 RadioGroup/RadioButton** - Seleção de multiplicadores (2x, 5x, 10x)
5. **☑️ CheckBox** - Aceitar "termos sarcásticos"
6. **📋 Spinner** - Menu dropdown para escolher "tigre da sorte"
7. **🔴 Button** - Botão principal "GIRAR E CHORAR"
8. **📊 ProgressBar** - Barra de progresso horizontal durante animações

### 🔹 **Componentes de Layout e Feedback**
9. **💬 Toast** - Mensagens temporárias de feedback e validação
10. **📜 ScrollView** - Container com scroll para dispositivos menores
11. **📐 LinearLayout** - Organização vertical dos elementos

### 🔹 **Recursos Extras**
- **🎨 Vector Drawable** - Ícone customizado do tigrinho
- **🎬 Animações** - ObjectAnimator para rotação e progresso
- **🎨 Temas personalizados** - Paleta dourada temática

---

## 🎮 Funcionalidades Implementadas

### 💰 **Sistema de Apostas Funcional**
- Saldo inicial de **R$ 100,00**
- Validação de entrada (valores, saldo, termos)
- Cálculo de probabilidades baseado no multiplicador

### 🎲 **Mecânica de Jogo**
| Multiplicador | Chance de Vitória | Probabilidade |
|---------------|-------------------|---------------|
| 2x            | 40%              | Iniciante     |
| 5x            | 15%              | Intermediário |
| 10x           | 5%               | Expert        |

### 🎭 **Sistema de Mensagens Sarcásticas**
- **10 mensagens de derrota** diferentes
- **5 mensagens de vitória** raras
- **Contador de perdas consecutivas**
- **Mensagens especiais** para sequências de derrotas

### 🎬 **Animações e Efeitos**
- **Rotação do tigrinho** durante aposta (3 segundos)
- **Barra de progresso** animada
- **Mudança de cores** baseada no saldo
- **Transições suaves** entre estados

### 🔄 **Sistema de Game Over**
- **Reset automático** quando saldo zera
- **Mensagem motivacional** sarcástica
- **Reinício** com novo saldo de R$ 100

---

## 📊 Estatísticas e Validações

### 📈 **Controle de Estado**
- Saldo em tempo real
- Perdas acumuladas
- Contador de derrotas consecutivas
- Desabilitação de controles durante processamento

### ✅ **Validações Implementadas**
- Campo vazio
- Valor inválido (≤ 0)
- Saldo insuficiente
- Termos não aceitos
- Estados de botões e campos

---

## 🛠️ Tecnologias Utilizadas

### 📱 **Desenvolvimento**
- **Linguagem**: Kotlin
- **IDE**: Android Studio
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 35

### 🎨 **Interface**
- **View System**: XML Layouts (não Compose)
- **Theme**: AppCompat Material Design
- **Animações**: ObjectAnimator
- **Recursos**: Vector Drawables, Shapes, Colors

### 📚 **Bibliotecas**
```kotlin
implementation("androidx.core:core-ktx")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")
```

---

## 🚀 Como Executar o Projeto

### 📋 **Pré-requisitos**
- Android Studio Arctic Fox ou superior
- JDK 11 ou superior
- Android SDK 35
- Gradle 8.7+
- Dispositivo/Emulador Android 7.0+

### 💻 **Passos para Instalação**

1. **Clone ou baixe o projeto**
   ```bash
   git clone [URL_DO_REPOSITORIO]
   ```

2. **Abra no Android Studio**
   - File → Open → Selecionar pasta do projeto

3. **Sincronize as dependências**
   - Aguarde o Gradle sync automático
   - Ou manualmente: File → Sync Project with Gradle Files

4. **Limpe e reconstrua** (se necessário)
   ```
   Build → Clean Project
   Build → Rebuild Project
   ```

5. **Execute o aplicativo**
   - Conecte dispositivo Android ou inicie emulador
   - Run → Run 'app' (ou pressione Shift+F10)

### 🔧 **Troubleshooting**
Se encontrar erros de compilação:
```
File → Invalidate Caches and Restart → Invalidate and Restart
```

---

## 📁 Estrutura do Projeto

```
TigrinhoApostador/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/tigrinhoapostador/
│   │   │   └── MainActivity.kt              # Lógica principal (300+ linhas)
│   │   ├── res/
│   │   │   ├── drawable/
│   │   │   │   ├── tiger_icon.xml          # Ícone vetorial customizado
│   │   │   │   ├── edit_text_background.xml # Background do EditText
│   │   │   │   └── spinner_background.xml   # Background do Spinner
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml        # Layout principal (150+ linhas)
│   │   │   └── values/
│   │   │       ├── colors.xml              # Paleta dourada
│   │   │       ├── strings.xml             # Textos do app
│   │   │       └── themes.xml              # Tema customizado
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts                     # Configurações do módulo
├── build.gradle.kts                         # Configurações do projeto
├── settings.gradle.kts
└── README.md                               # Este arquivo
```

---

## 🎨 Design e Interface

### 🎨 **Paleta de Cores**
```xml
#FFD700  <!-- Gold Background (Dourado) -->
#B8860B  <!-- Dark Gold (Dourado Escuro) -->
#4CAF50  <!-- Green (Verde - Ganhos) -->
#F44336  <!-- Red (Vermelho - Perdas) -->
#000000  <!-- Black (Preto - Texto) -->
#FFFFFF  <!-- White (Branco - Fundos) -->
```

### 📱 **Responsive Design**
- **ScrollView** para dispositivos pequenos
- **Padding consistente** (16dp)
- **Tamanhos proporcionais** de componentes
- **Cores contrastantes** para acessibilidade

### 🎭 **Tom Sarcástico**
- **Títulos**: "O app que te deixa pobre com estilo!"
- **Botão**: "GIRAR E CHORAR"
- **Opções**: "Iniciante na perda", "Profissional em falência"
- **Termos**: "Aceito perder todo meu dinheiro conscientemente"

---

## 🎯 Exemplos de Uso (Para Vídeo)

### 📹 **Roteiro Sugerido para Apresentação**

1. **🎬 Abertura (30s)**
   - Mostrar splash/inicialização
   - Apresentar interface principal
   - Destacar design dourado

2. **🔍 Demonstrar Componentes (60s)**
   ```
   ✅ ImageView → Ícone do tigrinho animado
   ✅ TextView → Múltiplos textos (saldo, títulos, etc.)
   ✅ EditText → Digitar valor da aposta
   ✅ RadioButton → Selecionar multiplicadores
   ✅ CheckBox → Aceitar termos
   ✅ Spinner → Escolher tigre
   ✅ Button → Botão de apostar
   ✅ ProgressBar → Animação de progresso
   ✅ Toast → Mensagens de validação
   ✅ ScrollView → Scroll da tela
   ✅ LinearLayout → Organização vertical
   ```

3. **🎮 Funcionalidades (90s)**
   - Fazer aposta pequena e **ganhar** (mostrar animações)
   - Fazer várias apostas e **perder** (mostrar mensagens sarcásticas)
   - Testar **validações** (campo vazio, saldo insuficiente)
   - Chegar ao **Game Over** e mostrar reset

4. **📊 Recursos Técnicos (30s)**
   - Mostrar animações funcionando
   - Demonstrar responsividade
   - Destacar mensagens educativas

**⏰ Total: ~3-4 minutos**

---

## 🎓 Aspectos Educacionais

### 🧠 **Lições Demonstradas**
1. **Probabilidade Real**: Chances baixas de vitória
2. **Casa Sempre Ganha**: Sistema matemático desfavorável
3. **Vício Progressivo**: Aumento de apostas após derrotas
4. **Perda Garantida**: Mensagens que alertam sobre riscos

### 📚 **Valor Acadêmico**
- **Arquitetura Android**: Activity, Layouts, Resources
- **Programação Kotlin**: OOP, Lambdas, Extensions
- **UI/UX Design**: Material Design, Responsividade
- **Lógica de Negócio**: Validações, Estados, Persistência
- **Boas Práticas**: Clean Code, Comentários, Organização

---

## 📈 Métricas do Projeto

### 📊 **Estatísticas de Código**
- **Linhas de Kotlin**: ~300 (MainActivity.kt)
- **Linhas de XML**: ~150 (activity_main.xml)
- **Componentes**: 11+ diferentes
- **Métodos**: 15+ funções organizadas
- **Validações**: 5+ diferentes tipos

### 🎯 **Requisitos Atendidos**
- ✅ **Single Screen App**: Uma única Activity
- ✅ **5+ Componentes**: 11 componentes diferentes
- ✅ **Funcional**: Sistema completo de apostas
- ✅ **Versionamento**: Código no GitHub
- ✅ **Apresentação**: Roteiro para vídeo

---

## ⚖️ Aviso Legal

### 📜 **Isenção de Responsabilidade**
```
⚠️  ESTE APLICATIVO É PURAMENTE EDUCACIONAL
    
❌ NÃO incentiva apostas reais
❌ NÃO possui integração com dinheiro real  
❌ NÃO coleta dados pessoais
❌ NÃO tem fins comerciais

✅ Tem propósito educativo sobre riscos de jogos de azar
✅ Utiliza tom sarcástico para DESENCORAJAR apostas
✅ É projeto acadêmico de desenvolvimento Android
```

---

## 👨‍💻 Desenvolvimento

### 🧑‍🎓 **Autor**
- **Projeto**: Acadêmico - Desenvolvimento Android
- **Linguagem**: Kotlin
- **Paradigma**: Orientado a Objetos
- **Arquitetura**: Model-View (Traditional Android)

### 🔄 **Versioning**
- **Versão**: 1.0
- **Build**: 1
- **Min SDK**: 24
- **Target SDK**: 35

### 📅 **Histórico**
- **v1.0**: Release inicial com todos os componentes requisitados

---

## 🎁 Extras Implementados

### ⭐ **Funcionalidades Bônus**
- **🎨 Ícone vetorial customizado** (tiger_icon.xml)
- **🎬 Animações suaves** (ObjectAnimator)
- **📱 Design responsivo** (ScrollView + LinearLayout)
- **🎭 +15 mensagens sarcásticas** diferentes
- **📊 Sistema de estatísticas** (perdas acumuladas)
- **🔢 Contador de sequências** de derrotas
- **🎨 Mudanças visuais** baseadas em estado
- **⚡ Performance otimizada** (handlers, timeouts)

### 🏆 **Qualidade de Código**
- **📝 Comentários explicativos** em todos os componentes
- **🔧 Separação de responsabilidades** (métodos organizados)
- **✅ Tratamento de erros** e validações
- **🎨 Recursos organizados** (colors, strings, drawables)
- **📱 Compatibilidade ampla** (Android 7.0+)

---

## 📞 Suporte

### 🐛 **Reportar Problemas**
Se encontrar bugs ou problemas:
1. Verifique os requisitos mínimos
2. Teste em emulador oficial Android
3. Documente o erro com screenshots
4. Compartilhe logs do Android Studio

### 📧 **Contato Acadêmico**
- **Disciplina**: Desenvolvimento Mobile Android
- **Objetivo**: Projeto de conclusão - Componentes Android
- **Foco**: Educação e conscientização social

---

## 🎓 Conclusão

O **Tigrinho Apostador** representa um projeto completo de desenvolvimento Android que combina:

- **🎯 Propósito social**: Educação sobre riscos de apostas
- **💻 Competência técnica**: Uso avançado de componentes Android  
- **🎨 Design cativante**: Interface dourada e intuitiva
- **📚 Valor acadêmico**: Demonstração prática de conhecimentos

Este projeto serve como **portfólio acadêmico** demonstrando domínio de desenvolvimento Android nativo, boas práticas de programação e responsabilidade social através de tecnologia educativa.

---

<div align="center">

### 🐯 **"O único jeito garantido de ganhar no jogo é não jogar!"** 🐯

**Projeto desenvolvido com fins educacionais - 2024**

</div>