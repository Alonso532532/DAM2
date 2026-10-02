from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QCheckBox, QLabel, QLineEdit, QPushButton, QGroupBox, QRadioButton, QGridLayout
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        grid = QGridLayout()

        grid.addWidget(Cuadrado("red"),0,0)
        grid.addWidget(Cuadrado("green"),0,1)
        grid.addWidget(Cuadrado("yellow"),1,2)
        grid.addWidget(Cuadrado("blue"),2,0)

        #Para el espaciado
        grid.setSpacing(20)

        # Para aplicar un layout es necesario un widget
        widget = QWidget()
        widget.setLayout(grid)
        self.setCentralWidget(widget)


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

