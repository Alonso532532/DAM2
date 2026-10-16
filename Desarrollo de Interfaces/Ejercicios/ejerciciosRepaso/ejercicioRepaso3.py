from PyQt6.QtWidgets import QMainWindow, QRadioButton, QMessageBox, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        # <=================================================>

        comunidad = QHBoxLayout()

        self.aragon = QRadioButton("Aragón")
        self.comunidadValenciana = QRadioButton("Comunidad Valenciana")

        self.aragon.setChecked(True)

        self.aragon.toggled.connect(self.cambiarAragon)
        self.comunidadValenciana.toggled.connect(self.cambiarValencia)


        comunidad.addWidget(self.aragon)
        comunidad.addWidget(self.comunidadValenciana)

        # <=================================================>
       
        self.combo = QComboBox()
        self.combo.addItems(["Huesca","Zaragoza","Teruel"])
       
        # <=================================================>
        layoutV = QVBoxLayout()

        layoutV.addLayout(comunidad)
        layoutV.addWidget(self.combo)


        contenedor = QWidget()
        contenedor.setLayout(layoutV)

        self.setCentralWidget(contenedor)

    def cambiarAragon(self):
        self.combo.clear()
        self.combo.addItems(["Huesca","Zaragoza","Teruel"])

    def cambiarValencia(self):
        self.combo.clear()
        self.combo.addItems(["Castellón","Valencia","Albacete"])
    
        

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
