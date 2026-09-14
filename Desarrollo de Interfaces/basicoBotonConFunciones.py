from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    clicks = 0

    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto

        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        boton = QPushButton("Pulsa") # Botón
        boton.setCheckable(True) # Lo hago marcable
        boton.clicked.connect(self.botonPulsado) # llama a la función cuando es pulsado
        boton.clicked.connect(self.saberEstado)

        self.setCentralWidget(boton) # situo el botón en toda la pantalla

    # Esta es la función que se ejecuta al activar el botón
    def botonPulsado(self): 
        self.clicks = self.clicks+1
        print(self.clicks)

    def saberEstado(self, checked): # El segundo parametro de una función llamada por "boton.clicked.connect" es el estado del botón
        print("Estado: ", checked)
        


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
