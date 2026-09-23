from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantilla = QHBoxLayout()

        plantilla.addWidget(Cuadrado("red"))
        plantilla.addWidget(Cuadrado("yellow"))
        plantilla.addWidget(Cuadrado("lime"))
        plantilla.addWidget(Cuadrado("green"))
        plantilla.addWidget(Cuadrado("yellow"))
        plantilla.addWidget(Cuadrado("red"))
        plantilla.addWidget(Cuadrado("yellow"))

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

