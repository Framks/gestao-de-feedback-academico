from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox(executable_path='./drive_firefox/geckodriver')

driver.get("http://localhost:3000/login")
try:
    # Acesse a página de login
    driver.get("http://localhost:3000/login")

    # Aguarde até o formulário de login aparecer
    search_box = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.CSS_SELECTOR, ".form-group"))
    )

    # Encontre os campos de login
    username_login = driver.find_element(By.ID, "username")
    password_login = driver.find_element(By.ID, "senha")
    search_button = driver.find_element(By.ID, "submit-login")

    # Preencha os campos e clique no botão de login
    username_login.send_keys("joao.silva@admin.com")
    password_login.send_keys("senha123")
    search_button.click()

    # Aguarde até o botão de logout aparecer
    logout_button = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "logout-button"))
    )

    # Clique no botão de logout
    logout_button.click()
    print("Login successful para admin")
except Exception as e:
    print(f"Error: {e}")
finally:
    # Feche o navegador
    driver.quit()