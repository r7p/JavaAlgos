

def num_platforms(arrivals: list, departures: list) -> int:
    result = 0
    count = 0

    for outer_index, outer_arrival in enumerate(arrivals):
        count = 0
        for i in range(1, len(arrivals)):
            if arrivals[outer_index] <= arrivals[i] <= departures[outer_index]:
                count += 1

        if result < count:
            result = count

    return result


def num_platforms_fast(arrivals: list, departures: list) -> int:
    # nlogn time
    arrivals.sort()
    departures.sort()

    total_arrivals = len(arrivals)
    arrival_index = 1
    departure_index = 0
    platform_needed = 1
    result = 0

    while arrival_index < total_arrivals and departure_index < total_arrivals:
        if departures[departure_index] > arrivals[arrival_index]:
            # we need a platform as previous train did not depart before arrival of next train
            platform_needed += 1
            # park the next train on to the platform
            arrival_index += 1
            if platform_needed > result:
                result = platform_needed
        else:
            platform_needed -= 1
            departure_index += 1

    return result


if __name__ == '__main__':
    arrivals = [900, 940, 950, 1100, 1500, 1800]
    departures = [910, 1200, 1120, 1130, 1900, 2000]

    print(num_platforms_fast(arrivals, departures))

    arrivals = [200, 210, 300, 320, 350, 500]
    departures = [230, 240, 320, 430, 400, 520]

    print(num_platforms_fast(arrivals, departures))
