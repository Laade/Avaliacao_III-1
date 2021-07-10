
<h3 align="center">
    <img alt="Logo" title="#logo" width="300px" src="/assets/imgs/logo_java.png">
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

   Avaliação referente a disciplina Programação Orientada a Objetos, ministrada pelo professor [Frederico Barboza](http://lattes.cnpq.br/2897532678011764), por meio do repositorio que se encontra [aqui](https://github.com/pooinf008/inf008-20211/tree/master/especificacao).

<a id="features"></a>

## Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

<details closed>
  <summary>Primeira Expecificação 🟢</summary>
  <br>
     <p>
      As cores RGB modelam um sistema de cores aditivas em que o Vermelho (Red), o Verde (Green) e o Azul (Blue) são combinados de várias formas de modo a reproduzir um largo espectro cromático. Uma cor RGB é representada por uma 3-upla, onde cada elemento pode assumir um valor de 0 a 255, representando a quantidade de vermelho, verde e azul que compõem a cor.
  
  Em cores RGB, a luminosidade é calculada através da expressão de luminosidade = (R*0.3 + G*0.59 + B *0.11) que deve ser truncada para um valor inteiro.
    </p>
    <ul>
        <details closed>
  <summary>Classe RGB 🟢</summary>
    <ul>
        <li> I. Uma classe que represente uma cor RGB. 🟢
        <li> II. A representação estática da classe criada. 🟢
        <li> III. Os métodos que lêem e alteram os valores das componentes RGB da cor. 🟢
        <li> IV. Um método que leia a luminosidade da cor. 🟢
        <li> V. Construtores sobrecarregados que permitam a criação de uma cor. 🟢
        <li> VI. Um construtor de cópia, que crie uma cor idêntica (mesmo valor de R, G e B). 🟢
        <li> VII. Um construtor sem parâmetros, que crie a cor preta (<R=0, G=0, B=0>). 🟢
        <li> VIII. Um construtor que receba três valores como parâmetros e crie uma considerando estes valores como os valores de R, G e B, respectivamente. 🟢
        <li> IX. Um método que verifique se duas cores são iguais. As cores são consideradas iguais se seus valores de R, G e B são idênticos entre si (o R de uma cor igual o R da outra e assim por diante). 🟢
        <li> X. Altere as propriedades Red, Green e Blue e Luminosidade para serem exclusivamente leitura. 🟢
        <li> XI. Um método que gere e retorne uma nova cor RGB equivalente ao cinza da cor RGB em questão. Essa cor possui os valores de R, G e B iguais entre si e iguais ao valor da luminosidade da cor original. Por exemplo, para a cor #2596BE, a cor gerada deverá ser #797979. 🟢
        <li> XII. Um método que gere uma representação String da cor como hexadecimal. A representação é composta pelo caracter # seguida de dois dígitos representando o valor de R, G e B em hexadecimal. Por exemplo, para a cor RGB, onde R=37, G=150, B=190, o método deve retornar: #2596BE. 🟢
        <li> XIII. Um método clarear que receba um valor e modifique a tonalidade da cor em questão a tornando mais clara. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual maior, onde p deve ser indicado como parâmetro. Por exemplo, para a cor  #2596BE, se o parâmetro de clarear for 0.1 (10%), a cor deve se tornar #3BA1C5. 🟢
        <li> XIV. Um método escurecer que receba um valor e modifique a tonalidade da cor em questão a tornando mais escura. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual menor, onde p deve ser indicado como parâmetro. Por exemplo, para a cor  #2596BE, se o parâmetro de escurecer for 0.1 (10%), a cor deve se tornar #2187AB. 🟢
        <li> XV. Um método que retorne uma nova instância de CorRGB, igual a cor que recebeu a mensagem. 🟢
        <li> XVI. Atributos de classe que permitam reduzir o número de instâncias em uso de cores comuns. 🟢
            <ul>
                <li> I.   PRETA #000000 🟢
                <li> II.  BRANCA #FFFFFF 🟢
                <li> III. RED #FF0000 🟢
                <li> IV.  GREEN #00FF00 🟢
                <li> V.   BLUE #0000FF 🟢
            </ul>
    </ul>
  </details>
    </ul>
     <ul>
        <details closed>
      <summary>Classe imagem 🟢</summary>
         Escreva uma classe que represente uma Imagem como um mapa bidimensional de cores RGB.
      <ul>
          <li> I. a representação estática da classe criada 🟢 
          <li>II. um construtor que crie uma Imagem. O tamanho da Imagem será passado como parâmetro no construtor. A imagem criada deve ter todos os píxels ajustados para o BRANCO 🟢 
          <li> III. um método que modifique o pixel de uma imagem dada a posição e o pixel 🟢 
          <li> IV. sobrecarregue este método para modifique o pixel de uma imagem dada a posição e os valores de RGB do pixel. 🟢 
          <li> V. método que verifique que duas imagens são iguais 🟢
          <li> VI. método que crie uma nova imagem com o equivalente em tons de cinza. Essa imagem deve ter os valores de cada pixel da cor original substituido pelo seu equivalente em cor de cinza. 🟢
          <li> VII. método que verifique se uma imagem é um fragmento da outra 🟢
      </ul>
    </details>
    </ul>
  </details>
  <details open>
    <summary>Segunda Expecificação 🟠</summary>
    <br>
      <p>
        Um sistema de avaliação de mapas para corrida de orientação funciona como se segue:
        O sistema é composto por uma biblioteca de imagens, que representam mapas de corrida de orientação. Cada imagem é composta por uma coleção bidimensional de pixels. Como as imagens provém de fontes distintas de captação, eles podem ser representadas por sistemas de representação de cores distintos. Atualmente, o atlas pode armazenar dois tipos de mapas, os mapas RGB e os mapas CMYK, contudo estuda-se a possibilidade da incorporação de outros modelos de representação (mapas HSV, por exemplo). Os mapas RGB são compostos por coleções bidimensionais de pixels de cores no formato RGB, enquanto os mapas CMYK são compostos por coleções bidimensionais de pixels de cores no forma­to CMYK. 
        As cores RGB modelam um sistema de cores aditivas em que o Vermelho (Red), o Verde (Green) e o Azul (Blue) são combinados de várias formas de modo a reproduzir um largo espectro cromático. Uma cor RGB é representada por uma 3-upla, onde cada elemento pode assumir um valor de 0 a 255, representando a quantidade de vermelho, verde e azul que compõem a cor.
        Já as cores CMYK modelam um sistema de cores subtrativas. Neste caso, cada cor é representada por uma 4-upla formado por ciano (Cyan), magenta (Magenta), amarelo (Yellow) e preto (Black (Key)). Cada um dos elementos desta tupla pode assumir um valor entre 0 e 100.
        <br>Pelo fato de operar com vários padrões de cores distintas, o sistema verifica a similaridade de duas cores quaisquer, através da distância (módulo da diferença) entre suas luminosidades (tom de cinza)<br>. Portanto, toda cor tem uma luminosidade associada independente do padrão. A luminosidade do padrão RGB é calculada através da expressão luminosidade = (R*0.3 + G*0.59 + B *0.11), que deve ser truncada para um valor inteiro. A luminosidade de uma cor CMYK é dado pela quantidade de preto (K) na cor multiplicado por 255 divido por 100 (luminosidade = K * 255 / 100).
      </p>
      <ul>
          <li> I. (3.0) – Escreva um modelo de classes que descreva adequadamente as classes de negócio do problema acima. 🟢
          <li> II. (4.0) – Escreva todos os métodos necessários para que o sistema receba uma 3-upla, representando uma cor RGB, um limiar de similaridade de luminosidade l e um percentual mínimo p e retorne todos os mapas que possuam ao menos o percentual mínimo p de pixels cuja luminosidade seja similar a da cor RGB informada em +/- l% . Por exemplo, o sistema pode ter que retornar todas as imagens com ao menos 40% dos pixels com luminosidade de +/- 10% do azul puro (0, 0, 255). 🔴
          <br>
          <br>
          <p>
            public Imagem[] getImagemPorLuminosidade(double red, double green, double blue, double pctMinimo, double limiarSimilaridade);
          </p>
          <br>
          <li> III. (3.0) –  O sistema quer incorporar a possibilidade de converter imagens de um sistema de cor para outro sistema de cor. Por exemplo, converter uma imagem em RGB para uma imagem CMYK; de uma imagem CMYK para uma imagem RGB, etc. O conversor deve criar uma imagem do tipo adequado (aquele que se quer converter) dada as dimensões da imagem original, e depois acrescentar na posição correta um novo pixel representado na cor destino da conversão. Um conversor foi escrito, com esta finalidade e o código é fornecido abaixo.
          Para que o conversor seja genérico ele foi baseado em interfaces. Adapte o conversor, para as classes do seu modelo e escreva o código da interface ConversorCor, e uma classe que possa ser utilizada pelo conversor para converter imagens de CMYK para RGB considerando as seguintes equações de conversão: 🟠
          <ul>
            <li> R = 255 × (1-C)/100 × (1-K)/100 
            <li> G = 255 × (1-M)/100 × (1-K)/100 
            <li> B = 255 × (1-Y)/100 × (1-K)/100 
          </ul>
      </ul>
    </details>

</br>

### Métodos Opcionais/sugestões
<li> Revisão de Models construídas na Expecificação I 🟢
<li> Uso de Testes Unitários para a aplicação. 🟠
<li> Verifica a similaridade de duas cores quaisquer, através da distância (módulo da diferença) entre suas luminosidades (tom de cinza). 🔴

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
- Digite (troque ReinanS pelo nome do seu usuário): git clone https://github.com/ReinanS/INF008-Avaliacao-I
- Nome da pasta: INF008-Avaliacao-I


<a id="how-to-contribute"></a>

## Como contribuir

- Fork este repositório,
- Crie sua branche com sua contribuição: `git checkout -b my-feature`
- Commit suas mudanças: `git commit -m 'feat: My new feature' `
- Push sua branch: `git push origin my-feature`

<h4 align="center">
    Made by <a href="https://github.com/ReinanS" target="_blank">Reinan Santos</a>
</h4>