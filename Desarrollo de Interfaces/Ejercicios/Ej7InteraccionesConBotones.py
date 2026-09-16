from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):

    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto

        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        boton = QPushButton("Pulsa") # Botón

        boton.pressed.connect(self.botonPulsado) # llama a la función cuando es pulsado

        boton.released.connect(self.botonSoltado) # llama a la función cuando es soltado
        
        boton.clicked.connect(self.botonPulsadoYSoltado) # llama a la función cuando es pulsado y soltado

        self.setCentralWidget(boton) # situo el botón en toda la pantalla
        
    # Estas funciónes se ejecuta al interactuar con el botón
    def botonPulsado(self): 
        print("Botón pulsado")

    def botonPulsadoYSoltado(self):
        print("Botón pulsado y soltado")

    def botonSoltado(self):
        print("Botón soltado")

    


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta