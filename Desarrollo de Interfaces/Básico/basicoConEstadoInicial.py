from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    clicks = 0

    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto

        self.botonPulsado = True # La inicializo con "self" para poder usarla fuera del "constructor"

        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        boton = QPushButton("Pulsa") # Botón

        boton.setCheckable(True) # Lo hago marcable

        boton.clicked.connect(self.botonActivado) # llama a la función cuando es pulsado

        boton.setChecked(self.botonPulsado) # Le asigno al botón el estado de la variable "botonPulsado"

        self.setCentralWidget(boton) # situo el botón en toda la pantalla

    def botonActivado(self,estado):

        self.botonPulsado=estado
        print(self.botonPulsado)

    
        


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
