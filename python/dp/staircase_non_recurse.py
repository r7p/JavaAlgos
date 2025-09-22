

def count_ways(n: int) -> int:

    lookup_table = [0 for i in range(n + 1)]

    # set first 3 values of lookup_table
    lookup_table[0] = 1
    lookup_table[1] = 1  # num of ways to climb 1 stair staircase
    lookup_table[2] = 2  # num of ways to climb 2 stair staircase

    for i in range(3, n + 1):
        lookup_table[i] = lookup_table[i - 1] + lookup_table[i - 2] + lookup_table[i - 3]

    return lookup_table[n]


if __name__ == '__main__':
    num_stairs = 5
    print(f"Combinations of hopping staircase {count_ways(num_stairs)}")
