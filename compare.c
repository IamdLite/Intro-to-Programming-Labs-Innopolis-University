#include <stdio.h>
#include <stdlib.h>

int compare_files(FILE *file1, FILE *file2) {
    char ch1, ch2;

    // Read both files byte by byte and compare
    while (((ch1 = fgetc(file1)) != EOF) && ((ch2 = fgetc(file2)) != EOF)) {
        if (ch1 != ch2) {
            // Files differ
            return 0;
        }
    }

    // Check if both files reached EOF
    if (feof(file1) && feof(file2)) {
        // Files are similar
        return 1;
    }

    // Files have different lengths
    return 0;
}

int main() {
    FILE *file1, *file2;
    char file1_path[100], file2_path[100];

    // Input the file paths
    printf("Enter the path of the first file: ");
    scanf("%s", file1_path);
    printf("Enter the path of the second file: ");
    scanf("%s", file2_path);

    // Open both files in read mode
    file1 = fopen(file1_path, "r");
    file2 = fopen(file2_path, "r");

    // Check if files are opened correctly
    if (file1 == NULL || file2 == NULL) {
        printf("Error: Could not open one or both files.\n");
        exit(EXIT_FAILURE);
    }

    // Compare the files
    if (compare_files(file1, file2)) {
        printf("The files are identical.\n");
    } else {
        printf("The files are different.\n");
    }

    // Close the files
    fclose(file1);
    fclose(file2);

    return 0;
}
