# /!\ Ceci est le makefile de test /!\ #

# Répertoire des fichiers sources du projet
SRC = ../../src
INCDIRS = -I../../src/appliBase
INCDIRS += -I../../src/glut
INCDIRS += -I../../src/math
INCDIRS += -I../../src/tetris
INCDIRS += -I../../src/dossier_de_test

# Répertoire des destinations des binaires
BIN = ../../bin/lanceurs_des_tests

# Usage des librairies Linux
LIBS = -lX11 -lglut -lGL -lGLU -lm

# Commande de compilation
# OPTFLAGS = -W -Wall -ansi -pedantic
OPTFLAGS = -Wall
GPP = g++ $(OPTFLAGS) $(INCDIRS)

all: testCIPiece testCTPiece testCOPiece testCL1Piece testCL2Piece testCZ1Piece testCZ2Piece

#------------------------------------------------------------
# execution classe de test de CIPiece, CTPiece et COPiece
#------------------------------------------------------------
testCIPiece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCIPiece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCIPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCIPiece.o

testCTPiece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCTPiece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCTPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCTPiece.o

testCOPiece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCOPiece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCOPièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCOPiece.o

testCL1Piece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCL1Piece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCL1Pièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCL1Piece.o

testCL2Piece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCL2Piece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCL2Pièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCL2Piece.o

testCZ1Piece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCZ1Piece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCZ1Pièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCZ1Piece.o

testCZ2Piece: CPieceAbstract.o CZ2Piece.o CZ1Piece.o CL2Piece.o CL1Piece.o COPiece.o CIPiece.o CTPiece.o testCZ2Piece.o CProjetTetrisPiece.o CTetrisGame.o CRandomizer.o CGuiGlut.o CApplication.o CRenderer.o CMatrix44.o CTGameTable.o
	$(GPP) -o $(BIN)/lanceurCZ2Pièce.bin $(BIN)/CPieceAbstract.o $(BIN)/CZ2Piece.o $(BIN)/CZ1Piece.o $(BIN)/CL2Piece.o $(BIN)/CL1Piece.o $(BIN)/COPiece.o $(BIN)/CIPiece.o $(BIN)/CTPiece.o $(LIBS)  $(BIN)/CProjetTetrisPiece.o $(BIN)/CTetrisGame.o $(BIN)/CRandomizer.o $(BIN)/CGuiGlut.o $(BIN)/CApplication.o $(BIN)/CRenderer.o $(BIN)/CMatrix44.o $(BIN)/CTGameTable.o $(BIN)/testCZ2Piece.o


#------------------------------------------------------------
# compilation projet tetris
#------------------------------------------------------------
CProjetTetrisPiece.o: $(SRC)/dossier_de_test/CProjetTetrisPiece.cpp
	$(GPP) -o $(BIN)/CProjetTetrisPiece.o -c $(SRC)/dossier_de_test/CProjetTetrisPiece.cpp

CTetrisGame.o: $(SRC)/tetris/CTetrisGame.cpp
	$(GPP) -o $(BIN)/CTetrisGame.o -c $(SRC)/tetris/CTetrisGame.cpp

CPieceAbstract.o: $(SRC)/tetris/CPieceAbstract.cpp
	$(GPP) -o $(BIN)/CPieceAbstract.o -c $(SRC)/tetris/CPieceAbstract.cpp

CIPiece.o: $(SRC)/tetris/CIPiece.cpp
	$(GPP) -o $(BIN)/CIPiece.o -c $(SRC)/tetris/CIPiece.cpp

CTPiece.o: $(SRC)/tetris/CTPiece.cpp
	$(GPP) -o $(BIN)/CTPiece.o -c $(SRC)/tetris/CTPiece.cpp

COPiece.o: $(SRC)/tetris/COPiece.cpp
	$(GPP) -o $(BIN)/COPiece.o -c $(SRC)/tetris/COPiece.cpp

CL1Piece.o: $(SRC)/tetris/CL1Piece.cpp
	$(GPP) -o $(BIN)/CL1Piece.o -c $(SRC)/tetris/CL1Piece.cpp

CL2Piece.o: $(SRC)/tetris/CL2Piece.cpp
	$(GPP) -o $(BIN)/CL2Piece.o -c $(SRC)/tetris/CL2Piece.cpp

CZ1Piece.o: $(SRC)/tetris/CZ1Piece.cpp
	$(GPP) -o $(BIN)/CZ1Piece.o -c $(SRC)/tetris/CZ1Piece.cpp

CZ2Piece.o: $(SRC)/tetris/CZ2Piece.cpp
	$(GPP) -o $(BIN)/CZ2Piece.o -c $(SRC)/tetris/CZ2Piece.cpp

CRandomizer.o: $(SRC)/tetris/CRandomizer.cpp
	$(GPP) -o $(BIN)/CRandomizer.o -c $(SRC)/tetris/CRandomizer.cpp

CTGameTable.o: $(SRC)/tetris/CTGameTable.cpp
	$(GPP) -o $(BIN)/CTGameTable.o -c $(SRC)/tetris/CTGameTable.cpp

#------------------------------------------------------------
# compilation application 3D + Matrix44
#------------------------------------------------------------
CGuiGlut.o:  $(SRC)/appliBase/CGuiGlut.cpp
	$(GPP) -o $(BIN)/CGuiGlut.o -c $(SRC)/appliBase/CGuiGlut.cpp

CApplication.o: $(SRC)/appliBase/CApplication.cpp
	$(GPP) -o $(BIN)/CApplication.o -c $(SRC)/appliBase/CApplication.cpp

CRenderer.o: $(SRC)/appliBase/CRenderer.cpp
	$(GPP) -o $(BIN)/CRenderer.o -c $(SRC)/appliBase/CRenderer.cpp

CMatrix44.o: $(SRC)/math/CMatrix44.cpp
	$(GPP) -o $(BIN)/CMatrix44.o -c $(SRC)/math/CMatrix44.cpp

main.o: $(SRC)/main.cpp
	$(GPP) -o $(BIN)/main.o -c $(SRC)/main.cpp


#------------------------------------------------------------
# compilation des tests de CPiece
#------------------------------------------------------------
testCTPiece.o: $(SRC)/dossier_de_test/testCIPiece.cpp
	$(GPP) -o $(BIN)/testCTPiece.o -c $(SRC)/dossier_de_test/testCTPiece.cpp

testCIPiece.o: $(SRC)/dossier_de_test/testCIPiece.cpp
	$(GPP) -o $(BIN)/testCIPiece.o -c $(SRC)/dossier_de_test/testCIPiece.cpp

testCOPiece.o: $(SRC)/dossier_de_test/testCOPiece.cpp
	$(GPP) -o $(BIN)/testCOPiece.o -c $(SRC)/dossier_de_test/testCOPiece.cpp

testCL1Piece.o: $(SRC)/dossier_de_test/testCL1Piece.cpp
	$(GPP) -o $(BIN)/testCL1Piece.o -c $(SRC)/dossier_de_test/testCL1Piece.cpp

testCL2Piece.o: $(SRC)/dossier_de_test/testCL2Piece.cpp
	$(GPP) -o $(BIN)/testCL2Piece.o -c $(SRC)/dossier_de_test/testCL2Piece.cpp

testCZ1Piece.o: $(SRC)/dossier_de_test/testCZ1Piece.cpp
	$(GPP) -o $(BIN)/testCZ1Piece.o -c $(SRC)/dossier_de_test/testCZ1Piece.cpp

testCZ2Piece.o: $(SRC)/dossier_de_test/testCZ2Piece.cpp
	$(GPP) -o $(BIN)/testCZ2Piece.o -c $(SRC)/dossier_de_test/testCZ2Piece.cpp



#------------------------------------------------------------
# autres commandes
#------------------------------------------------------------
clean:
	rm -rf $(BIN)/*.o

mrproper: clean
	rm -rf $(BIN)/tetris.bin

cleansrctetris:
	rm -f $(SRC)/tetris/*.*~
