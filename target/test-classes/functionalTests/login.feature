Feature: "Login e Cadastro"

  @regressao @cadastro3 @teste2 @Chrome
  Scenario Outline: Login with wrong credentials
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user send wrong password
    Examples: 
       | password |
       |   206832 |    

  @regressao @cadastro4  @teste2 @Chrome
  Scenario Outline: Gerando boleto - PF 
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    And I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 
    And I click at create a bank slip button
    And I click at first option of bank slip 
    And I send the value of my bank slip  as "<value>"
    And I send the due date of my bank slip 
    And I click at continue button 
    And I click at generate a bank slip button 
    And I send my card password as "<cardpassword>"
    And I confirm the generation of my bank slip
    And I check my bankslip history  
    Examples: 
       | newpassword  | password    |  value 	  |		cardpassword	|
       |   406867   	|  206831	    |	 55,00    |		  2068			  |

 @regressao @cadastro2 @teste2 @Chrome
  Scenario Outline: I forgot my password
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    And I click at forgot button
    And I send my cpf to reset my password
    And I send my email to reset my password
    And I send my cellPhone as "<cellphone>"
    And I send my birthday to reset my password
    And I click at redefine password button
    And I use my cpf at login page
    And I click at Continuar button
    And I send new password
    And I click at login button
    And I send reset password 
    And I send my new password
    And I repeat my new password 
    And click at save password button 
    And I use my cpf at login page
    And I click at Continuar button
    And I send my password as "<password>"
    And I click at Entrar button
       Examples: 
        | newpassword  |password  | 
        |   406867 	 	 |206831	  | 

  @regressao @cadastro3 @teste2 @Chrome
  Scenario Outline: Change Password - PF 
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    And I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 
    And I click at account menu
    And I click at change password menu
    And I send my old passowrd as "<password>" 
    And I send my new passowrd as "<newpassword>"
    And I confirm my new passowrd as "<newpassword>" 
    And I click at my save button
    And I click at ok button to confirm the password change 
   	And  I use my cpf at login page
    And I click at Continuar button
    And I send my password as "<newpassword>"
    And I click at Entrar button
    And I check if user is logged 
    Examples: 
      | newpassword  |password |
      |   406867     |206831	 |
    

      
  @regressao @cadastro5  @teste2 @Chrome
  Scenario Outline: Login with right credentials
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 

    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |   
      | 087.819.858-00 |   206831 |  
      
      
 @regressao @cadastro3 @teste2 @Chrome
  Scenario Outline: Creating a virtual card
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged  
 		And I click at cards menu 
    And I create a virtual card 
    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |    
	
	      
  @regressao @cadastro10 @teste2 @Chrome
  Scenario Outline: Creating a extra card
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged  
 		And I click at cards menu 
    And I create a extra card 
    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |    
	
	
	
	 @regressao @cadastro2 @yCards @Chrome 
  Scenario Outline: Recharging my card 
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged  
 		And I click at cards menu  
 		And I click at first card  
    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |    
	
	
	
	
	 @regressao @cadastro2 @vCards @Chrome 
  Scenario Outline: Recharging my card - virtual
    Given I open the homepage
 		When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged  
 		And I click at cards menu 
 		And I click at virtual card  
    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |    
	

	
	   @regressao @cadastro2 @teste2 @Chrome
  Scenario Outline: Get user information
    Given I open the homepage
    When I use my cpf at login page
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 
    And I click at user information
    And I check user information
    

    Examples: 
      | cpf        		 | password |
      | 087.819.858-00 |   206831 |    
	
	 @regressao @cadastro1 @teste @Chrome
  Scenario Outline: Login with right credentials
    Given I open the homepage
    When I use my cpf at login page without lgpd 
    And I click at Continuar button
    Then I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 
    And I send my termo lgpd as "<lgpd>"
    Examples: 
      | cpf        		 | password |lgpd  |
      | 087.819.858-00 |   206831 |true  |   
	    | 087.819.858-00 |   206831 |false |  
			
  @regressao @cadastro @Chrome
  Scenario Outline: Create an account - PF
    Given I open the homepage
    And I click at creat an account link
    And I send my cpf
    And I send my new password as "<password>"
    And I repeat my new password as "<password>"
    And I choose my fees
    And I choose my terms as "<termoAceite>" and termoComunicao as "<termoComunicacao>" and termoLGPD as "<termoLgpd>"
    And I send my name
    And I send my birthday
    And I send my mothers' name
    And I send my cellphone
    And I send my cellphone token
    And I send my email
    And I send my email token
    And I dont send my document's phots
    And I choose my gender
    And I send my zipCode
    And I send my adress number 
    And I send my card new password as "<passwordCard>"
    And I repeat my card new password as "<passwordCard>"
    And I click at ok button
    And I use my cpf to login
    And I click at Continuar button
    And I send my password as "<password>"
    And I click at Entrar button
    And I check if user is logged 

    Examples: 
      | cpf         | password |	termoAceite  | termoComunicacao|termoLgpd    | passwordCard |
      | 86274099000 |   206831 |    true       |	true 					 |true 			   |  2068 		  	|
	
	
	