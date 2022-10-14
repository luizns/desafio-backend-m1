# DESAFIO BACKEND M.1

## Descrição 

A aplicação tem por objetivo simular um ambiente de uma loja virtual.

Onde é possivel realizar algumas opereções no gerenciamento do seu produto com as seguintes ações:

* Cadastrar um produtos
* Alterar um produtos
* Excluir um produtos
* Importar um produtos
* Listar os produtos cadastrados

### Como rodar a aplicação:

Para iniciar a aplicação é necessário ter configurado: 
 * Java JDK: a partir da versão 11.
 * IDE/Editor de Codigo:  Eclipse, Intellij ou VSCode

Importante: Se for utilizar o sistema operacional Windows verificar os Paths com caminhos do arquivos.

Ex:
```
C:\\temp\\Documents\\estoque.csv
```

### Funcionalidades - Tela Principal
Após iniciar a aplicação aparecerá a seguintes a tela:
```
**************************************************
               CONTROLE DE PRODUTOS
**************************************************

 [1] - Cadastro Produto
 [2] - Alterar Produto
 [3] - Excluir Produto
 [4] - Importar Arquivos
 [5] - Listar Produtos Cadastrados
 [6] - Sair
 Opcao: 
```
Nesta tela, o usuário deverá escolher a opção para realizar um operação.
<hr>

### Cadastrar novo usuários
- ####  Menu opção: 01

```
**************************************************
               CADASTRO DE PRODUTOS
**************************************************

Digite os dados do produtos que desejar cadastrar:
Nome Produto: Celular
Preço: 1250,50
Quantidade: 2
Categoria: Eletrônicos
```
### Alterar Produto
- ####  Menu opção: 02

Nesta opção você irá informar o código do produto que deseja alterar, logo após
de encontrar o produto, aparecerá  um submenu e você escolherá a opção que deseja alterar.

```
****** LISTA DE PRODUTOS *****
***********************************
CODIGO    NOME PRODUTO     CATEGORIA   QTD.  VALOR   
t0n75ytr - Teclado Gamer - ESCRITÓRIO - 1 - R$ 120,99

Informe o produto que desejar alterar
z29byvui
Escolhar o opçao que deseja alterar
[1] - Nome
[2] - Preço
[2] - Quantidade
[3] - Categoria
[4] - Cancelar
2
Preço: 25,0
```
### Excluir Produto
- ####  Menu opção: 03

```
****** EXCLUI DE PRODUTOS *****
***********************************

INFORME O PRODUTO QUE DESEJAR EXCLUIR
heqti1q0
Produto removido com sucesso
```
Na opção 3, tem por finalidade excluir um produto da lista através do **CODIGO**

### Importar  Produto
- ####  Menu opção: 04
Nesta operação requer muito cuidado, pois precisa de um arquivo no modelo abaixo:

Tabela com campos necessários para geração do arquivos.

|código|codigo de barras|série|nome|descrição|categoria| valor bruto                         | impostos (%)               | data de fabricação       | data de validade | cor      | material |
|------|----------------|-----|----|---------|---------|-------------------------------------|----------------------------|--------------------------|-----------------|----------|----------|
|7t0do00n|629936360072|2/2016|Livro Design Patterns|"Livro sobre padrões de projeto de Erich Gamma, Ralph Johnson, Richard Helm e John Vlissides"|ESCRITÓRIO| "101,11"| 25| 18/05/2016| n/a| n/a| papel    |

Modelo do arquivos gerado com extensão CSV (Ex: `arquivo.csv`)
```
código,codigo de barras,série,nome,descrição,categoria,valor bruto,impostos (%),data de fabricação,data de validade,cor,material
t0n75ytr,945923371680,1/2017,Teclado Gamer,Teclado mecânico para jogos com luzes RGB,ESCRITÓRIO,"120,99",35,23/12/2016,n/a,colorido,plástico

```

Para importar, escolha opção 4 do menu:

``` 
 Opcao: 4

---------------------------------------------
 ****** IMPORTAR CATALOGO DE PRODUTOS *****
---------------------------------------------
Digite caminho do arquivo: Ex: '/home/pc/desktop/arquivo.csv' 
'/home/pc/desktop/arquivo.csv' 
```

### Listar Produtos Cadastrados
- ####  Menu opção: 5

Está opção irá mostrar todos produtos cadastrados.

```
Opcao: 5
****** LISTA DE PRODUTOS *****
***********************************
CODIGO    NOME PRODUTO     CATEGORIA   QTD.  VALOR   
t0n75ytr - Teclado Gamer - ESCRITÓRIO - 1 - R$ 120,99
```
### Sair do sistema
- ####  Menu opção: 6
Para sair do sistema é só digitar o número no menu principal que o produto será encerrado.


##### Em Desenvolvimento...
