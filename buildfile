Buildr.settings.build['scala.version'] = "2.9.1"
require 'buildr/scala'

# Version number for this release
VERSION_NUMBER = "1.0.0"
# Group identifier for your projects
GROUP = "jm-euler-scala"
COPYRIGHT = ""

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"
repositories.remote << 'https://repository.jboss.org/nexus/content/repositories/releases'
repositories.remote << 'http://scala-tools.org/repo-releases/'
repositories.remote << 'http://scala-tools.org/repo-snapshots/'


desc "The Jm-euler-scala project"
define "jm-euler-scala" do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  test.using(:scalatest)

end
