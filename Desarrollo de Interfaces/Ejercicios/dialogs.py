from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QDialog, QDialogButtonBox
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class CustomDialog(QDialog):
    # Pongo  ", parent=None" y luego "parent" en "init" para poder pasarle un padre al crearlo
    def __init__(self, parent=None):
        super().__init__(parent)

        self.setWindowTitle("Cuadro de dialogo")

        # Para añadir botones a un "QDialogButtonBox" se usa "QDialogButtonBox" para elegir el tipo de botón que tiene sus métodos y sus movidas y si se quieren añadir varios se puede hacer con "|"
        self.dialogBox = QDialogButtonBox(QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel)

        # Le añado las funciones a los botónes
        self.dialogBox.accepted.connect(self.accept)
        self.dialogBox.rejected.connect(self.reject)

        # Creo la interfáz del dialog
        self.plantilla = QVBoxLayout()
        texto = QLabel("Hecproll (Si o No)")

        self.plantilla.addWidget(texto)
        self.plantilla.addWidget(self.dialogBox)

        self.setLayout(self.plantilla)

        


