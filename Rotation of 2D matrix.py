def rotate_columns(matrix, times=3):
    rows, cols = len(matrix), len(matrix[0])

    for _ in range(times):
        # Rotate each column independently
        last_row = matrix[-1][:]  # Copy last row
        
        for r in range(rows - 1, 0, -1):  # Shift each column downward
            for c in range(cols):
                matrix[r][c] = matrix[r - 1][c]

        # Move last row to first row
        for c in range(cols):
            matrix[0][c] = last_row[c]

    return matrix

# Example usage
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    [10, 11, 12]
]

rotated_matrix = rotate_columns(matrix, 1)
for row in rotated_matrix:
    print(row)


