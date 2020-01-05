#! /usr/bin/python2


import os
from os import path
# if path.exists("/home/pi/hx711py/temp/tarage_java.txt"):
#         os.remove("/home/pi/hx711py/temp/tarage_java.txt")
# if path.exists("/home/pi/hx711py/temp/pesee_java.txt"):
#         os.remove("/home/pi/hx711py/temp/pesee_java.txt")

tarage_java = open("/home/pi/hx711py/temp/tarage_java.txt","w")
## indiquer que le tarage est pret
tarage_java.write("0")

pesee_java = open("/home/pi/hx711py/temp/pesee_java.txt","w")
## indiquer la variable "val" dans le fichier.
pesee_java.write("0")

import time
import sys
import RPi.GPIO as GPIO
from hx711 import HX711

referenceUnit = 115.93

def cleanAndExit():
    print("                Sortie...")
    sys.exit()

hx = HX711(5, 6)
hx.set_reading_format("MSB", "MSB")
hx.set_reference_unit(referenceUnit)
hx.reset()
hx.tare()
print("-------------- TARAGE EFFECTUE ---------------")

tarage_java = open("/home/pi/hx711py/temp/tarage_java.txt","w")
## indiquer que le tarage est pret

tarage_java.write("1")
tarage_java.close()

i=0

while 1:
        
    val = hx.get_weight(5)
    print(val)

    hx.power_down()
    hx.power_up()
    time.sleep(0.1)
    if val > 50:
        i = i+1
    if i == 3:
        break

pesee_java = open("/home/pi/hx711py/temp/pesee_java.txt","w")
## indiquer la variable "val" dans le fichier.
pesee = str(val)
pesee_f, sep, tail = pesee.partition(".")
pesee_java.write(pesee_f)
pesee_java.close()



cleanAndExit()

