from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantillav = QVBoxLayout()

        #boton1 = QPushButton("Botón 1")
        #boton2 = QPushButton("Botón 2")
        #boton3 = QPushButton("Botón 3")

        #boton1.clicked.connect(self.botonPulsado)
        #boton2.clicked.connect(self.botonPulsado)
        #boton3.clicked.connect(self.botonPulsado)

        # Padding
        #plantillav.setContentsMargins(10,10,10,10)
        # Espaciado entre elementos
        plantillav.setSpacing(10)

        #plantillav.addWidget(boton1)
        #plantillav.addWidget(boton2)
        #plantillav.addWidget(boton3)

        for i in range(20):
            boton = QPushButton(f"Botón {i+1}")
            boton.clicked.connect(self.botonPulsado)
            plantillav.addWidget(boton)


        # Para aplicar un layout es necesario un widget

        widget = QWidget()
        widget.setLayout(plantillav)
        self.setCentralWidget(widget)

    def botonPulsado(self):
        # Con self.sender() llamo al elemento que ha llamado a la función
        # Si antes de una cadena se pone "f" se pueden añadir variables
        print(f"Has pulsado el botón {self.sender().text()}")


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

