# Design Patterns em Java Puro

Este repositório contém um desafio de código que explora a implementação de Design Patterns utilizando Java puro, sem frameworks. Os padrões abordados são Facade, Singleton, e Strategy, além dos subsistemas Crm e Cep.

## O que é Design Pattern?

Design Patterns são soluções reutilizáveis para problemas comuns que ocorrem frequentemente no desenvolvimento de software. Eles representam as melhores práticas desenvolvidas por desenvolvedores experientes e podem ajudar a tornar o código mais flexível, reutilizável e fácil de manter.

## Principais Design Patterns

Os Design Patterns são geralmente classificados em três categorias:

1. **Padrões Criacionais**: Tratam da criação de objetos, ajudando a tornar o sistema independente de como seus objetos são criados, compostos e representados. Exemplos incluem Singleton, Factory, Abstract Factory, Builder e Prototype.
2. **Padrões Estruturais**: Tratam da composição de classes e objetos para formar estruturas maiores. Exemplos incluem Adapter, Composite, Proxy, Decorator, Facade, Bridge e Flyweight.
3. **Padrões Comportamentais**: Tratam da comunicação entre objetos, distribuindo responsabilidades de forma eficaz. Exemplos incluem Strategy, Observer, Command, Iterator, Mediator, Memento, State, Template Method e Visitor.

## Estrutura do Código

O código está organizado nos seguintes pacotes:

- **Facade**
- **Singleton**
- **Strategy**
- **SubsistemaCrm**
- **SubsistemaCep**

### Padrão Facade

O padrão Facade oferece uma interface simplificada para um conjunto de interfaces em um subsistema. Ele define uma interface de alto nível que torna o subsistema mais fácil de usar.

#### Código:

```java
package br.com.devleofulco.facade;

import br.com.devleofulco.subsistemaCrm.CrmService;
import br.com.devleofulco.subsistemaCep.CepApi;

public class Facade {
    public void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);
        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
```

### Padrão Singleton

O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.

#### Código:

**Aplication.java**

```java
package br.com.devleofulco.singleton;

public class Aplication {
    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLayHolder holder = SingletonLayHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLayHolder.getInstancia();
        System.out.println(holder);
    }
}
```

**App.java**

```java
package br.com.devleofulco.singleton;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
```

**SingletonEager.java**

```java
package br.com.devleofulco.singleton;

public class SingletonEager {
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }
}
```

**SingletonLayHolder.java**

```java
package br.com.devleofulco.singleton;

public class SingletonLayHolder {
    private static class InstanceHolder {
        public static SingletonLayHolder instancia = new SingletonLayHolder();
    }

    private SingletonLayHolder() {
        super();
    }

    public static SingletonLayHolder getInstancia() {
        return InstanceHolder.instancia;
    }
}
```

**SingletonLazy.java**

```java
package br.com.devleofulco.singleton;

public class SingletonLazy {
    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia() {
        if (instancia == null) {
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
```

### Padrão Strategy

O padrão Strategy define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O padrão Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

#### Código:

**Comportamento.java**

```java
package br.com.devleofulco.strategy;

public interface Comportamento {
    void mover();
}
```

**ComportamentoAgressivo.java**

```java
package br.com.devleofulco.strategy;

public class ComportamentoAgressivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Movendo de forma agressiva...");
    }
}
```

**ComportamentoDefensivo.java**

```java
package br.com.devleofulco.strategy;

public class ComportamentoDefensivo implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Movendo-se defensivamente...");
    }
}
```

**ComportamentoNormal.java**

```java
package br.com.devleofulco.strategy;

public class ComportamentoNormal implements Comportamento {
    @Override
    public void mover() {
        System.out.println("Movendo normalmente...");
    }
}
```

**Robo.java**

```java
package br.com.devleofulco.strategy;

public class Robo {
    private Comportamento comportamento;

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void mover() {
        comportamento.mover();
    }
}
```

### SubsistemaCrm

O subsistema CRM (Customer Relationship Management) gerencia informações sobre os clientes.

#### Código:

**CrmService.java**

```java
package br.com.devleofulco.subsistemaCrm;

public class CrmService {
    public CrmService() {
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado) {
        System.out.println("Cliente salvo na camada de sistema de CRM:");
        System.out.println(nome);
        System.out.println(cidade);
        System.out.println(cep);
        System.out.println(estado);
    }
}
```

### SubsistemaCep

O subsistema CEP (Código de Endereçamento Postal) fornece informações sobre cidades e estados com base no CEP.

#### Código:

**CepApi.java**

```java
package br.com.devleofulco.subsistemaCep;

public class CepApi {
    private static CepApi instancia = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstancia() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "Araraquara";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
```
