from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox
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

        # Layout 1 =============================================
        hLayout = QHBoxLayout()

        label = QLabel("Hola")
        edit = QLineEdit()

        hLayout.addWidget(label)
        hLayout.addWidget(edit)

        # Layout 2 =============================================
        vLayout = QVBoxLayout()

        check = QCheckBox("Selección")
        button = QPushButton("Pulsa")

        vLayout.addWidget(check)
        vLayout.addWidget(button)

        # para añadir los layout hay que esconderlos en widgets

        widget1 = QWidget()
        widget2 = QWidget()

        widget1.setLayout(hLayout)
        widget2.setLayout(vLayout)

        tabs.addTab(widget1, "pestaña1")
        tabs.addTab(widget2, "pestaña2")

        self.setCentralWidget(tabs)
        

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
