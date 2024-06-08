# Esocopo do projeto:

Descrição do Projeto FinanSea:
  
O projeto FinanSea surge como uma resposta inovadora aos crescentes desafios ambientais enfrentados pelos oceanos, incluindo a destruição de habitats marinhos, poluição e mudanças climáticas. Tais problemas têm consequências não apenas para os ecossistemas marinhos, mas também para a economia global. Em busca de soluções sustentáveis que garantam a preservação dos oceanos, o FinanSea tem como missão assegurar que as atividades humanas nos oceanos sejam ecologicamente responsáveis, socialmente inclusivas e economicamente viáveis a longo prazo.
Para alcançar esses objetivos, o FinanSea propõe a criação de uma plataforma de crowdfunding dedicada à preservação e revitalização da costa brasileira. Esta plataforma inovadora permitirá que Organizações Não Governamentais (ONGs) divulguem suas iniciativas ambientais e captem os recursos financeiros necessários para a implementação de projetos de sustentabilidade dos oceanos.

Funcionalidade da plataforma:

Na plataforma FinanSea, as ONGs poderão se cadastrar de forma intuitiva, fornecendo informações detalhadas sobre suas atividades, incluindo nome, email, endereço, dados bancários e logotipo. Uma vez cadastradas, as ONGs poderão registrar novos projetos, especificando metas de arrecadação, descrição detalhada, imagens ilustrativas e status do projeto. Além disso, a plataforma permitirá que as ONGs acompanhem em tempo real a evolução da arrecadação de fundos e solicitem o resgate dos recursos levantados, garantindo transparência e eficiência na gestão financeira dos projetos.
Para os doadores, sejam eles indivíduos ou empresas, a plataforma oferecerá uma experiência de uso amigável e segura. Após o cadastro, os doadores poderão explorar diversos projetos com captação aberta, fazer contribuições financeiras e acompanhar de perto o progresso dos projetos que ajudaram a financiar. Através de um aplicativo móvel, os doadores terão acesso a atualizações em tempo real, permitindo um envolvimento contínuo e uma maior conscientização sobre os impactos positivos de suas contribuições.
Um componente essencial da plataforma será um blog informativo, onde serão documentados os impactos positivos dos projetos apoiados pelo FinanSea. Este blog servirá como uma ferramenta de comunicação vital, relatando o progresso dos projetos concluídos, em andamento e aqueles que estão em fase de captação. As publicações incluirão descrições detalhadas, imagens e relatos de impacto, criando uma narrativa envolvente que manterá os doadores engajados e confiantes na eficácia de suas contribuições.
Além disso, o FinanSea oferecerá um espaço exclusivo para patrocinadores, que poderão fornecer cupons de desconto e outras ofertas especiais aos doadores. Esta funcionalidade incentivará doações adicionais, promovendo uma maior participação da comunidade empresarial e fortalecendo a rede de apoio aos projetos de sustentabilidade dos oceanos.


Impacto e Sustentabilidade:

Através da plataforma FinanSea, espera-se criar uma rede colaborativa robusta entre ONGs, doadores e patrocinadores, promovendo práticas de gestão ambiental sustentáveis. O projeto visa não apenas arrecadar fundos, mas também conscientizar a sociedade sobre a importância da preservação dos oceanos, incentivando a participação ativa de diversos stakeholders na luta contra os desafios ambientais.
Com esta abordagem abrangente, o FinanSea visa contribuir significativamente para a Economia Azul, promovendo um desenvolvimento sustentável que equilibre necessidades econômicas com a preservação ambiental. A plataforma FinanSea pretende se tornar um catalisador para mudanças positivas, garantindo que os oceanos permaneçam saudáveis e produtivos para as futuras gerações, ao mesmo tempo em que fortalece as comunidades locais e promove uma economia global mais sustentável.

Funcionalidades da Plataforma:
- Cadastro de ONGs: Informações detalhadas, incluindo nome, email, endereço, dados bancários e logotipo.
- Registro de Projetos: Metas de arrecadação, descrição detalhada, imagens ilustrativas e status do projeto.
- Acompanhamento de Fundos: Monitoramento em tempo real da evolução da arrecadação e solicitação de resgate de recursos.
- Experiência do Doadores: Navegação por projetos, contribuições financeiras, acompanhamento do progresso e atualizações em tempo real.
- Blog Informativo: Documentação dos impactos positivos dos projetos, com descrições detalhadas, imagens e relatos de impacto.
- Espaço para Patrocinadores: Ofertas especiais e cupons de desconto para incentivar doações adicionais.

# Endpoints:

## BANC_ACCOUNT
#### GET/POST: http://localhost:5009/bank_account
#### PUT/DELETE: http://localhost:5009/bank_account/{id}

#### [
    { 
               "id": long,
               "accountNumber": string,
               "agency": string,
               "password": string
     }
  ]


## DONATION
#### GET/POST: http://localhost:5009/donation
#### PUT/DELETE: http://localhost:5009/donation/{id}

#### [ 
    {
    "amount": BigDecimal(float),
    "project": {
        "id": long,
        "name": string,
        "address": string,
        "description": string,
        "goal": BigDecimal(float),
        "status": string,
        "proofOfTheProject": string,
        "accumulated": BigDecimal(float),
        "ong": {
            "id": long,
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
            }
        }
    },
    "donor": {
            "id": long,
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
             }
    }
}
  ]



## FINANCIER
#### GET/POST: http://localhost:5009/financier
#### PUT/DELETE: http://localhost:5009/financier/{id}

#### [
    
    {
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
             }
    }

  ]

## ONG
#### GET/POST: http://localhost:5009/ong
#### PUT/DELETE: http://localhost:5009/ong/{id}

####  [
     {
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
             }
    }
  ]

## PROJECT
#### GET/POST: http://localhost:5009/project
#### PUT/DELETE: http://localhost:5009/project/{id}

####  [
    {
      "name": string,
      "address": string,
      "description": string,
      "goal": BigDecimal(float),
      "status": string,
      "proofOfTheProject": string,
      "accumulated": BigDecimal(float),
      "ong":   {
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
             }
        }
      }
  ]

## PUBLICATION
#### GET/POST: http://localhost:5009/pubçication
#### PUT/DELETE: http://localhost:5009/publication/{id}

 #### [
    {
        "description": string,
        "ong": {
            "id": long,
            "document": string,
            "name": string,
            "email": string,
            "password": string,
            "address": string,
            "telephone": string,
            "bankData": {
                "id": long,
                "accountNumber": string,
                "agency": string,
                "password": string
            }
        }
    }
  ]
