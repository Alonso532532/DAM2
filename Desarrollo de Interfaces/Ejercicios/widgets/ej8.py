from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        self.boton = QPushButton("Pulsa") # Botón

        self.boton.setCheckable(True) # Lo hago marcable

        self.boton.clicked.connect(self.botonPulsadoYSoltado) # llama a la función cuando es pulsado y soltado

        self.boton.setChecked(True)

        self.setCentralWidget(self.boton) # situo el botón en toda la pantalla
        
    # Estas funciónes se ejecuta al interactuar con el botón
    def botonPulsadoYSoltado(self):
        print(self.boton.isChecked())


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta