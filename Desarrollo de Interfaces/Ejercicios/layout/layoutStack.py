from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QCheckBox, QLabel, QLineEdit, QPushButton, QGroupBox, QRadioButton, QGridLayout, QStackedLayout
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        stack = QStackedLayout()
        
        stack.addWidget(Cuadrado("red"))
        stack.addWidget(Cuadrado("blue"))
        stack.addWidget(Cuadrado("yellow"))
        stack.addWidget(Cuadrado("black"))
        stack.addWidget(Cuadrado("green"))

        #se puestra el elemento que tenga ese index
        stack.setCurrentIndex(2)
        
        # Para aplicar un layout es necesario un widget
        widget = QWidget()
        widget.setLayout(stack)
        self.setCentralWidget(widget)


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

