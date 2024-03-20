# Change Log

## [Versão 1.0.0] - 2024-03-20

### added
desenvolvido a funcionalidade para validação de token seguindo as seguintes regras
- Deve ser um JWT válido
- Deve conter apenas 3 claims (Name, Role e Seed)
- A claim Name não pode ter carácter de números
- A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)
- A claim Seed deve ser um número primo.
- O tamanho máximo da claim Name é de 256 caracteres.
