#include <stdio.h>

int main(){
	for(int i = 1; i <=100; i++){
		if(i % 5 == 0 && i % 7 == 0){
			puts("FizzBuzz");
		} else if (i % 5 == 0 && i % 7 != 0){
			puts("Fizz");
		} else if (i % 5 != 0 && i % 7 == 0){
			puts("Buzz");
		} else{
			printf("%d\n", i);
		}
	}
	return 0;
}
