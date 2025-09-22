
def count_ways(n: int) -> int:

    if n < 0:
        return 0
    elif n == 0:
        return 1
    else:
        return count_ways(n - 1) + count_ways(n - 2) + count_ways(n - 3)


if __name__ == '__main__':
    print(f"Combinations of hopping staircase {count_ways(3)}")
