from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        tabs = QTabWidget()

        # Le digo donde tienen que estar las pestañas 
        tabs. setTabPosition(QTabWidget.TabPosition.North)
        # Si va a poder mover el orden de las pestañas
        tabs.setMovable(True)

        tabs.addTab(Cuadrado("black"), "Rojo")
        tabs.addTab(Cuadrado("white"), "Amarillo")

        self.setCentralWidget(tabs)
        

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
