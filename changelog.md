# Change Log


## [version 1.0.4] - 2024-03-25
### change
- alteração na organização da pasta utils, transferindo ela para application para ter mais coerencia com o contexto da aplicação

## [version 1.0.3] - 2024-03-22

### added
- Implementação do OTEL para observabilidade da aplicação
- Contenerização da aplicação com docker
- analise de cobertura de testes com jacoco

## [version 1.0.2] - 2024-03-21

### added
- Implementação do OTEL para observabilidade da aplicação
- Contenerização da aplicação com docker
- analise de cobertura de testes com jacoco

## [version 1.0.1] - 2024-03-21

### added
- Validação no body para não permir body nulo ou em branco
- melhorias no codigo
- criação de testes unitarios e integração
- criação de recursos para monitoria da aplicação

## [version 1.0.0] - 2024-03-20

### added
desenvolvido a funcionalidade para validação de token seguindo as seguintes regras
- Deve ser um JWT válido
- Deve conter apenas 3 claims (Name, Role e Seed)
- A claim Name não pode ter carácter de números
- A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)
- A claim Seed deve ser um número primo.
- O tamanho máximo da claim Name é de 256 caracteres.
