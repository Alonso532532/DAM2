from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantilla = QHBoxLayout()

        plantillav1 = QVBoxLayout()
        plantillav2 = QVBoxLayout()

        plantillav1.addWidget(Cuadrado("red"))
        plantillav1.addWidget(Cuadrado("yellow"))
        plantillav1.addWidget(Cuadrado("red"))

        plantillav2.addWidget(Cuadrado("red"))
        plantillav2.addWidget(Cuadrado("yellow"))
        plantillav2.addWidget(Cuadrado("red"))

        plantilla.addLayout(plantillav1)
        plantilla.addWidget(Cuadrado("gray"))
        plantilla.addLayout(plantillav2)


        # Para aplicar un layout es necesario un widget

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

