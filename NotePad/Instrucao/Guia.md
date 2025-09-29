

## **1. Escolher a tecnologia para GUI**

Em Java, tens duas opções principais para interfaces gráficas:

* **Swing** – mais simples, bem documentado, ideal para projetos como este.
* **JavaFX** – mais moderno, permite layouts mais flexíveis e estilos bonitos, mas é ligeiramente mais complexo.

Para começar, **Swing** é suficiente.

**Sugestão:** Usa `JFrame` como janela principal e `JTextArea` como área de edição de texto.

---

## **2. Estrutura básica da aplicação**

O Notepad terá essencialmente três componentes:

1. **Janela principal (`JFrame`)**

   * Título da janela: “Meu Notepad”
   * Layout: podes usar `BorderLayout` (JTextArea no centro, menus no topo)

2. **Área de texto (`JTextArea`)**

   * Onde o utilizador escreve o texto
   * Com `JScrollPane` para permitir scroll

3. **Menu (`JMenuBar`)**

   * Menu File: `Novo`, `Abrir`, `Salvar`, `Salvar Como`, `Sair`
   * Menu Edit: `Cortar`, `Copiar`, `Colar`, `Selecionar Tudo`
   * Opcional: Menu Help: `Sobre`

---

## **3. Funcionalidades essenciais**

### **a) File Menu**

* **Novo** → Limpa o `JTextArea`.
* **Abrir** → Abre um `JFileChooser`, lê o conteúdo de um ficheiro e mostra no `JTextArea`.
* **Salvar** → Salva o texto atual no ficheiro aberto (ou pede caminho se for novo).
* **Salvar Como** → Salva o texto atual em um novo ficheiro escolhido pelo utilizador.
* **Sair** → Fecha a aplicação, idealmente pedindo confirmação se houver alterações não salvas.

---

### **b) Edit Menu**

* **Cortar / Copiar / Colar** → Usa métodos do `JTextArea` (`cut()`, `copy()`, `paste()`).
* **Selecionar Tudo** → `selectAll()`.
* **Opcional:** Desfazer / Refazer (mais avançado, usa `UndoManager`).

---

### **c) Outras ideias**

* **Atalhos de teclado** (`Ctrl+S`, `Ctrl+O`, `Ctrl+N`) → Usa `KeyStroke` e `InputMap/ActionMap`.
* **Status Bar** (opcional) → Mostra linha e coluna do cursor.
* **Tema escuro / claro** (opcional) → Muda cores do `JTextArea` e `JFrame`.

---

## **4. Organização do projeto**

Sugestão de estrutura de classes:

* `MeuNotepad.java` → Classe principal com `main`, cria a janela.
* `Editor.java` → Classe que cria `JTextArea`, menus e eventos.
* `ArquivoUtils.java` → Métodos estáticos para ler/escrever ficheiros.

Se quiseres, podes manter tudo numa classe só no início e refatorar depois.

---

## **5. Passos práticos para implementar**

1. Criar a janela (`JFrame`) e colocar o `JTextArea` com `JScrollPane`.
2. Criar o `JMenuBar` com menus e items.
3. Adicionar **ActionListeners** aos items do menu para executar ações.
4. Implementar as funções de abrir, salvar, novo e sair.
5. Implementar os comandos de edição (copiar, colar, cortar).
6. Testar atalhos de teclado.
7. (Opcional) Adicionar funcionalidades extras como barra de status ou tema escuro.

---

## **Layout do Notepad (Swing)**

```
┌───────────────────────────────────────────┐
│                 JFrame                    │
│───────────────────────────────────────────│
│ JMenuBar (Menu Superior)                  │
│  ┌───────────┐ ┌───────────┐ ┌─────────┐  │
│  │ File      │ │ Edit      │ │ Help    │  │
│  └───────────┘ └───────────┘ └─────────┘  │
│                                           │
│  JTextArea (Área de Edição de Texto)      │
│  ┌─────────────────────────────────────┐  │
│  │                                     │  │
│  │                                     │  │
│  │                                     │  │
│  │                                     │  │
│  └─────────────────────────────────────┘  │
│                                           │
│ Status Bar (Opcional: Linha/Coluna)       │
│  "Linha: 1, Coluna: 1"                    │
└───────────────────────────────────────────┘
```

---

### **Detalhes de cada componente**

1. **JFrame**

   * Janela principal.
   * Layout sugerido: `BorderLayout`

     * `NORTH` → JMenuBar
     * `CENTER` → JTextArea (dentro de JScrollPane)
     * `SOUTH` → Status Bar (opcional)

2. **JMenuBar**

   * **File**

     * Novo (Ctrl+N)
     * Abrir (Ctrl+O)
     * Salvar (Ctrl+S)
     * Salvar Como
     * Sair
   * **Edit**

     * Cortar (Ctrl+X)
     * Copiar (Ctrl+C)
     * Colar (Ctrl+V)
     * Selecionar Tudo (Ctrl+A)
   * **Help** (opcional)

     * Sobre

3. **JTextArea + JScrollPane**

   * Onde o usuário digita o texto.
   * Coloca dentro de `JScrollPane` para scroll vertical/horizontal.

4. **Status Bar (Opcional)**

   * JLabel no `BorderLayout.SOUTH`.
   * Mostra posição do cursor ou número de caracteres/linhas.

---

### **Fluxo de ações**

1. Usuário clica em “Novo” → JTextArea é limpo.
2. Usuário clica em “Abrir” → JFileChooser abre, lê arquivo, popula JTextArea.
3. Usuário clica em “Salvar” → Salva conteúdo do JTextArea no arquivo atual.
4. Usuário clica em “Cortar/Copiar/Colar” → JTextArea executa ação correspondente.
5. Usuário fecha janela → Confirma se existem alterações não salvas.

---

