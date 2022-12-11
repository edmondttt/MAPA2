/* 
Author: Yi Kiu Tsang, ytsang3@myseneca.ca, 165809211, Date written: 6 Aug 2022, CPR101, Project
[main.exe] : [tokenizing]
Purpose: [Breaks the string into a series of tokens using the delimiter of " "(space)]
*/



// TOKENIZING MODULE SOURCE
#define _CRT_SECURE_NO_WARNINGS
#define BUFFER_SIZE 300        //allocate memory for the Cstring


// breaks the string into a series of tokens using the delimiter of " "(space)
void tokenizing(void)          // Version 1
{
    printf("*** Start of Tokenizing Words DEmo ***\n");
    char words[BUFFER_SIZE];   // words will be used to store user input
    char* nextWord = NULL;     // nextWords will be used to store the address of the first token found in the string
    int wordsCounter;          // wordsCounter stored the number of times of tokenizing

    do
    {
        printf("Type a few words separated by space (q - to quit):\n");
        fgets(words, BUFFER_SIZE, stdin);      // prompting for user input from the keyboard, input will be stored in string format
        words[strlen(words) - 1] = '\0';       // erasing the newline character from the user input stroed in words
        if (strcmp(words, "q") != 0 )          // checking if the user wants to quit the program
        {
            nextWord = strtok(words, " ");     // nextWord stored the address of the tokenizing word
            wordsCounter = 1;                  // initialise wordsCounter = 1
            while (nextWord)                   // break the while loop when nextWord == NULL (end of string)
            {
                //printing the tokenizing result while incrementing wordsCounter
                printf("Word #%d is \'%s\'\n", wordsCounter++, nextWord);  
                nextWord = strtok(NULL, " ");  // tell strtok to keep working on the same string we passed in, give us next piece of the string
            }
        }
    } while (strcmp(words, "q") != 0);         // break while loop when the user input is 'q'
    printf("*** End of Tokenizing Words Demo ***\n\n"); 
}