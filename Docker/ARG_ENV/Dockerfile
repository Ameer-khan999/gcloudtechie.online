ARG version
FROM almalinux:${version:-9}

# Re-declare ARG so it's accessible inside the build stage
ARG version
ARG trainer="Ameer" \
    course="Docker"

# Persist as Environment Variables
ENV trainer=${trainer} \
    course=${course} \
    version=${version:-9}

# Execute when the container runs
CMD echo "trainer is ${trainer} and course is ${course}, version is ${version}"
