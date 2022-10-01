import pyautogui as pg
from time import sleep

sleep(4)
for i in range(10**3):
    pg.keyDown("command")
    pg.press("v")
    pg.keyUp("command")
    pg.press("enter")