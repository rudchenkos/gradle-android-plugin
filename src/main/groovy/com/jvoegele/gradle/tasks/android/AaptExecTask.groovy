package com.jvoegele.gradle.tasks.android

class AaptExecTask extends AndroidAntTask {

  public AaptExecTask(project) {
    super(project);
  }

  /* (non-Javadoc)
   * @see com.jvoegele.gradle.tasks.android.AndroidAntTask#execute(java.util.Map)
   */
  @Override
  public void execute(Map args) {
    ant.aaptexec(executable: ant.aapt,
                 command: args.get('command', 'package'),
                 manifest: androidConvention.androidManifest.path,
                 resources: androidConvention.resDir.path,
                 assets: androidConvention.assetsDir,
                 androidjar: ant['android.jar'],
                 outfolder: project.buildDir,
                 basename: project.name)
  }

}
