hs: HomeSecurity.o Parser.o main.o
	g++ -g -o hs HomeSecurity.o Parser.o main.o

main.o: main.cpp
	g++ -g -c main.cpp

HomeSecurity.o: HomeSecurity.cpp HomeSecurity.h
	g++ -g -c HomeSecurity.cpp

Parser.o: Parser.cpp Parser.h
	g++ -g -c Parser.cpp
	
clean:
	rm -f *.o hs
	
level_1:
	@echo "\n*** Level 1 Echo Test ***"
	./hs  hs_l1_in.txt > test1.txt
	diff test1.txt hs_l1_out.txt
	
level_2:
	@echo "\n*** Level 2 Tests ***"
	./hs  hs_l2_in.txt > test2.txt
	diff test2.txt hs_l2_out.txt
	
level_3:
	@echo "\n*** Level 3 Tests ***"
	./hs  hs_l3_in.txt > test3.txt
	diff test3.txt hs_l3_out.txt
	
level_4:
	@echo "\n*** Level 4 Tests ***"
	./hs  hs_l4_in.txt > test4.txt
	diff test4.txt hs_l4_out.txt
	
level_5:
	@echo "\n*** Level 5 Tests ***"
	./hs  hs_l5_in.txt > test5.txt
	diff test5.txt hs_l5_out.txt
	
testall: level_2 level_3 level_4 level_5

all: clean hs
