from PyQt6.QtGui import QColor, QPalette
from PyQt6.QtWidgets import QWidget


class Cuadrado(QWidget):
    def __init__(self, color):
        super().__init__()

        self.setAutoFillBackground(True)

        # Hago una paleta roja
        paleta = self.palette()
        paleta.setColor(QPalette.ColorRole.Window, QColor(color))

        # Y la aplico
        self.setPalette(paleta)

