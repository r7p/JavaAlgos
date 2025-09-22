

def count_ways(lookup_table: list, n: int) -> int:

    if n < 0:
        return 0
    elif n == 0:
        return 1
    elif lookup_table[n] > -1:
        return lookup_table[n]
    else:
        lookup_table[n] = count_ways(lookup_table, n - 1) + count_ways(lookup_table, n - 2) + count_ways(lookup_table, n - 3)

    return lookup_table[n]


if __name__ == '__main__':
    num_stairs = 5
    cache = [-1 for i in range(num_stairs + 1)]
    print(f"Combinations of hopping staircase {count_ways(cache, num_stairs)}")
