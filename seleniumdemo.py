from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.expected_conditions import presence_of_element_located

from time import sleep

#This example requires Selenium WebDriver 3.13 or newer
with webdriver.Chrome() as driver:

    wait = WebDriverWait(driver, 10)

    # Tells the browser driver to go to the web address specified
    driver.get("https://google.com/ncr")

    # Gets the q element (The element with "name" = "q")
    q_element = wait.until(presence_of_element_located((By.NAME, "q")))
    q_element.send_keys("cheese" + Keys.RETURN)

    # Do something with the results
    first_result = wait.until(presence_of_element_located((By.CSS_SELECTOR, "h3>div")))
    print(first_result.get_attribute("textContent"))

    # Pause for next step
    sleep(5)

    # Do it again, but this time using XPath

    # Tells the browser driver to go to the web address specified
    driver.get("https://google.com/ncr")

    # Gets the q element (The element with "name" = "q")
    q_element = wait.until(presence_of_element_located((By.XPATH, "//input[@name='q']")))

    print()
    print(q_element.get_attribute("data-ved"))
    print()

    # Send query to text box.
    q_element.send_keys("enchiladas" + Keys.RETURN)

    # Do something with the results
    res_element = wait.until(presence_of_element_located((By.XPATH, "//h3/div")))
    print(res_element.text)

    # Pause for next step
    sleep(5)

    #print(driver.page_source.encode("utf-8"))
