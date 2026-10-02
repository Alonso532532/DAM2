from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")
        
        vLayout = QVBoxLayout()
        hLayout = QHBoxLayout()
        
        # botones
        boton1 = QPushButton("red")
        boton2 = QPushButton("green")
        boton3 = QPushButton("yellow")
        
        # Uso lambda para poder devolverle a "boton1.clicked.connect" una función y esa función ejecuta la función pasandole parámetros
        boton1.clicked.connect(lambda: self.stack.setCurrentIndex(0))
        boton2.clicked.connect(lambda: self.stack.setCurrentIndex(1))
        boton3.clicked.connect(lambda: self.stack.setCurrentIndex(2))
        
        hLayout.addWidget(boton1)
        hLayout.addWidget(boton2)
        hLayout.addWidget(boton3)
        
        vLayout.addLayout(hLayout)
        
        # Stacked Layout
        self.stack = QStackedLayout()
        self.stack.addWidget(Cuadrado("red"))
        self.stack.addWidget(Cuadrado("green"))
        self.stack.addWidget(Cuadrado("yellow"))
        
        vLayout.addLayout(self.stack)
                
        # Contenedor central
        widget = QWidget()
        widget.setLayout(vLayout)
        self.setCentralWidget(widget)
        

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
