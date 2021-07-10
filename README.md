<h3 align="center">
    <img alt="Logo" title="#logo" width="200px" heigth="100px" src="/assets/imgs/logo_java.png">
    </br>
    </br>
    </br>
    <b>Leitor Imagem</b>  
</h3>
  
<p align="center">
  <a href="#about">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#features">Ajustes e melhorias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#technologies-used">Tecnologias Utilizadas</a>
</p>

<a id="about"></a>

## Sobre

   Um aplicativo deseja fornecer um serviço de avaliação de mapas de corridas de orientação. Em uma das funcionalidades, o aplicativo deve permitir, que um mapeador possa avaliar a prevalência de elementos em um mapa. Os elementos de um mapa são identificados pela sua cor na imagem.

<a id="features"></a>

## Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- funcionalidade para avaliar a prevalencia de elementos em um mapa (imagem é um conjunto bidimensional de pixels). 🔴
- funcionalidade que retorna a quantidade percentual de pixels equivalente a uma cor informada. 🔴
- funcionalidade que lê o arquivo do usuário e é armazenada na model mapa. 🟠
  - criacao da Controller MapaDAOIF 🟠
  - criacao da Controller MapaDAOFile 🟠

- Ajustes nas models:
  - Adicionar atributo id, descricao, símbolo e tipo (RGB ou CMYK) à model Cor 🔴

- conexão com o banco

- Listagem do que ainda precisa ser feito
  - verificação de tipo da imagem


o sistema deve conter:

- carregamento de arquivo 🔴
- banco de dados 🔴
- view 🔴
- codigo 🟠

### Métodos Opcionais/sugestões

- Uso de Testes Unitários para a aplicação. 🟠
</br>

##### Legenda
- 🟢 = `Feito`.
- 🟠 = `Fazendo`.
- 🔴 = `Pendente/Falta`.

<a id="technologies-used"></a>

## Tecnologias Utilizadas

Esse projeto foi desenvolvido utilizando a seguinte tecnologia, e pacotes:

- [Java](https://www.java.com/pt-BR/)

<a id="how-to-use"></a>

## Como clonar e importar

- Faça um fork do projeto
- Abra o terminal do Visual Studio Code
- Digite (troque lorenascarvalho pelo nome do seu usuário): git clone https://github.com/lorenascarvalho/Avaliacao_III
- Nome da pasta: Avaliacao_III

<a id="how-to-contribute"></a>

## Como contribuir

- Fork este repositório,
- Crie sua branche com sua contribuição: `git checkout -b my-feature`
- Commit suas mudanças: `git commit -m 'feat: My new feature' `
- Push sua branch: `git push origin my-feature`
