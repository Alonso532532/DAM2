from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QCheckBox, QLabel, QLineEdit, QPushButton, QGroupBox, QRadioButton
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantilla1 = QVBoxLayout()
        plantilla11 = QVBoxLayout()
        plantilla2 = QHBoxLayout()

        grupo1 = QGroupBox("Botones")
        grupo2 = QGroupBox("Radios")

        boton1 = QPushButton("Botón 1")
        boton2 = QPushButton("Botón 2")
        boton3 = QPushButton("Botón 3")

        boton1.clicked.connect(self.botonPulsado)
        boton2.clicked.connect(self.botonPulsado)
        boton3.clicked.connect(self.botonPulsado)

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)

        radio1 = QRadioButton("Botón 1")
        radio2 = QRadioButton("Botón 2")
        radio3 = QRadioButton("Botón 3")

        plantilla11.addWidget(radio1)
        plantilla11.addWidget(radio2)
        plantilla11.addWidget(radio3)
        
        # Para añadir un grupo hay que añadirle un layout y luego añadirlo como widget a otro layout o lo q sea
        grupo1.setLayout(plantilla1)
        grupo2.setLayout(plantilla11)
        plantilla2.addWidget(grupo2)
        plantilla2.addWidget(grupo1)

        # Para aplicar un layout es necesario un widget
        widget = QWidget()
        widget.setLayout(plantilla2)
        self.setCentralWidget(widget)

    def botonPulsado(self):
        # Con self.sender() llamo al elemento que ha llamado a la función
        # Si antes de una cadena se pone "f" se pueden añadir variables
        print(f"Has pulsado el botón {self.sender().text()}")

    def activar(self):
        print("Hola")

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

